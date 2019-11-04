package com.zyd.sop.biz.apiservice.controller.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class VideoMediaParams {


    @NotNull(message = "请上传文件")
    @ApiModelProperty(value = "文件", required = true)
    private MultipartFile file1;

    /**
     * file_theme
     */
    private String fileTheme;

    /**
     * file_album
     */
    private String fileAlbum;

    /**
     * file_title
     */
    private String fileTitle;

    /**
     * file_size
     */
    private Long fileSize;

    /**
     * file_path
     */
    private String filePath;

    /**
     * file_name
     */
    private String fileName;

    /**
     * file_type
     */
    private String fileType;

    /**
     * create_time
     */
    private String createTime;

    /**
     * update_time
     */
    private String updateTime;

    /**
     * file_descr
     */
    private String fileDescr;

    /**
     * file_lgtd
     */
    private Long fileLgtd;

    /**
     * file_lttd
     */
    private Long fileLttd;

    /**
     * time_stamp
     */
    private String timeStamp;

    /**
     * bookmark
     */
    private String bookmark;

    /**
     * duration
     */
    private String duration;
}
