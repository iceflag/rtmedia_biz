package com.zyd.sop.biz.apiservice.controller;

import com.zyd.sop.biz.apiservice.controller.params.FileUploadParam;
import com.zyd.sop.biz.apiservice.controller.params.FileUploadParam2;
import com.zyd.sop.biz.apiservice.controller.result.FileUploadResult;
import com.zyd.sop.biz.fegin.FileUploadApi;
import com.zyd.sop.servercommon.annotation.ApiMapping;
import com.zyd.sop.servercommon.util.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Collection;

/**
 * 演示文件上传
 *
 */
@RestController
@Api(tags = "文件上传", position = 2)
public class FileUploadDemoController {

    @Autowired
    FileUploadApi fileUploadApi;
    /**
     * 方式1：将文件写在参数中，可直接获取。好处是可以校验是否上传;
     * @param param
     * @return
     */
    @ApiOperation(value = "文件上传例1", notes = "上传文件demo")
    @ApiMapping(value = "demo.file.upload")
    public FileUploadResult file1(FileUploadParam param) {
        System.out.println(param.getRemark());
        // 获取上传的文件
        MultipartFile file1 = param.getFile1();
        MultipartFile file2 = param.getFile2();

        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",file1.getContentType()
                , true, file1.getOriginalFilename());

        try{
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(file1.getInputStream(), os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);
        fileUploadApi.uploadFile(multi,"123/123");
        FileUploadResult result = new FileUploadResult();
        FileUploadResult.FileMeta fileMeta1 = buildFileMeta(file1);
        FileUploadResult.FileMeta fileMeta2 = buildFileMeta(file2);

        result.getFiles().add(fileMeta1);
        result.getFiles().add(fileMeta2);
        return result;
    }

    /**
     * 方式2：从request中获取上传文件
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "文件上传例2", notes = "可上传多个文件"
            // 多文件上传、不确定文件数量上传，必须申明下面这句，否则沙盒界面不会出现上传控件
            , extensions = @Extension(properties = @ExtensionProperty(name = "multiple", value = "multiple")))
    @ApiMapping(value = "demo.file.upload2")
    public FileUploadResult file2(FileUploadParam2 param, HttpServletRequest request) {
        //TODO Demo只演示了上传过来并获取文件元素信息返回，并没有存储。此处可根据实际存储情况存储到其他地方，并返回访问资源URL，返回给前端
        System.out.println(param.getRemark());
        FileUploadResult result = new FileUploadResult();
        // 获取上传的文件
        Collection<MultipartFile> uploadFiles = UploadUtil.getUploadFiles(request);
        for (MultipartFile multipartFile : uploadFiles) {
            FileUploadResult.FileMeta fileMeta = buildFileMeta(multipartFile);
            result.getFiles().add(fileMeta);
        }
        return result;
    }


    private FileUploadResult.FileMeta buildFileMeta(MultipartFile multipartFile) {
        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        // 文件大小
        long size = multipartFile.getSize();
        // 文件内容
        String fileContent = null;
        try {
            //TODO 此处用来演示上传的文件获取文件内容，后续实际上传不需要获取内容返回给前端。
            fileContent = IOUtils.toString(multipartFile.getInputStream(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileUploadResult.FileMeta(fileName, size, fileContent);
    }
}
