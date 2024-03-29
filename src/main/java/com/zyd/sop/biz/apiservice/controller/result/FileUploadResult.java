package com.zyd.sop.biz.apiservice.controller.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanghc
 */
@Data
public class FileUploadResult {

    private List<FileMeta> files = new ArrayList();

    @Data
    public static class FileMeta {

        public FileMeta(String filename, long size, String fileTheme) {
            this.filename = filename;
            this.size = size;
            this.fileTheme = fileTheme;
        }

        public FileMeta() {
        }

        @ApiModelProperty(dataType="string",value = "文件名称")
        private String filename;
        @ApiModelProperty(value = "文件大小")
        private long size;
        @ApiModelProperty(dataType="string" ,value = "文件主题")
        private String fileTheme;
    }
}
