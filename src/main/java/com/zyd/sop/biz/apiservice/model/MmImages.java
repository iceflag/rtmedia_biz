package com.zyd.sop.biz.apiservice.model;


import lombok.Data;

import java.io.Serializable;

/**
 *  图片信息记录表
 * @author zly 2019-11-03
 */
@Data
public class MmImages implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * file_theme
     */
    private String fileTheme;

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
     * thumb_path
     */
    private String thumbPath;

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

    public MmImages() {
    }

}
