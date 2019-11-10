package com.zyd.sop.biz.apiservice.controller.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DownLoadParam {
    @ApiModelProperty(value = "文件名称")
    private long fileName;
    @ApiModelProperty(value = "文件主题")
    private String fileTheme;
}
