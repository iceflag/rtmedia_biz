package com.zyd.sop.biz.fegin;


import com.zyd.sop.biz.config.FileFeignConfig;
import com.zyd.sop.biz.fegin.entity.UploadFileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "biz-fileupload", configuration = FileFeignConfig.class)
public interface FileUploadApi {

    @RequestMapping(method = RequestMethod.POST, value = "/uploadFile",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadFileResponse uploadFile(@RequestPart(value = "file") MultipartFile file, @RequestParam(value = "subDir") String subDir);

    @RequestMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam(value = "filePath") String filePath);
}
