package com.zyd.sop.biz.apiservice.controller.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DownLoadParam {
    @ApiModelProperty(value = "文件名称", example = "1.txt")
    private long fileName;
    @ApiModelProperty(value = "文件主题", example = "啊啊啊")
    private String fileTheme;
}
