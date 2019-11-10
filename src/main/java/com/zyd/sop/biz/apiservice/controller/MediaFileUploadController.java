package com.zyd.sop.biz.apiservice.controller;

import com.zyd.sop.biz.apiservice.controller.params.DownLoadParam;
import com.zyd.sop.biz.apiservice.controller.params.ImageMediaParams;
import com.zyd.sop.biz.apiservice.controller.result.FileUploadResult;
import com.zyd.sop.biz.fegin.FileUploadApi;
import com.zyd.sop.biz.utils.DateUtils;
import com.zyd.sop.servercommon.annotation.ApiMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@Api(tags = "多媒体文件上传下载", position = 2)
public class MediaFileUploadController {


    @Autowired
    private FileUploadApi fileUploadApi;
    @ApiOperation(value = "图片文件上传", notes = "图片文件上传")
    @ApiMapping(value = "media.image.upload")
    public FileUploadResult file1(ImageMediaParams param) {

        // 获取上传的文件
        MultipartFile file1 = param.getFile1();

        //TODO 无法直接转换成CommonMultipartFile，所以先用临时文件存储后转发
        String fileTheme=param.getFileTheme();
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",file1.getContentType()
                , true, file1.getOriginalFilename());

        try{
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(file1.getInputStream(), os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);
        fileUploadApi.uploadFile(multi,param.getFileTheme()+File.separator+ DateUtils.getDate());
        FileUploadResult result = new FileUploadResult();
        FileUploadResult.FileMeta fileMeta1 = buildFileMeta(file1,fileTheme);

        result.getFiles().add(fileMeta1);
        return result;
    }


    @ApiOperation(value = "视频文件上传", notes = "视频文件上传")
    @ApiMapping(value = "media.vedio.upload")
    public FileUploadResult file2(ImageMediaParams param) {
        // 获取上传的文件
        MultipartFile file1 = param.getFile1();

        String fileTheme=param.getFileTheme();
        //TODO 无法直接转换成CommonMultipartFile，所以先用临时文件存储后转发
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",file1.getContentType()
                , true, file1.getOriginalFilename());

        try{
            OutputStream os = fileItem.getOutputStream();
            IOUtils.copy(file1.getInputStream(), os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);
        fileUploadApi.uploadFile(multi,param.getFileTheme()+File.separator+ DateUtils.getDate());

        FileUploadResult result = new FileUploadResult();
        FileUploadResult.FileMeta fileMeta1 = buildFileMeta(file1,fileTheme);

        result.getFiles().add(fileMeta1);
        return result;
    }


    @ApiOperation(value = "文件下载", notes = "文件下载")
    @ApiMapping(value = "file.download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE/* 这个一定要加，不然沙箱文档不起作用 */)
    public ResponseEntity<byte[]> download(DownLoadParam param) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        // 假设下载classpath下的application.properties文件
      //  ClassPathResource resource = new ClassPathResource("/application.properties");

        ResponseEntity<Resource> resourceResponseEntity=fileUploadApi.downloadFile(param.getFileTheme()+ File.separator+param.getFileName());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", resourceResponseEntity.getBody().getFilename());

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(IOUtils.toByteArray(resourceResponseEntity.getBody().getInputStream()));
    }


    private FileUploadResult.FileMeta buildFileMeta(MultipartFile multipartFile,String fileTheme) {
        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        // 文件大小
        long size = multipartFile.getSize();

        return new FileUploadResult.FileMeta(fileName, size, fileTheme);
    }
}
