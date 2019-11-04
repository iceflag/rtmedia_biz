package com.zyd.sop.biz.apiservice.mapper;

import com.zyd.sop.biz.apiservice.model.MmVideos;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 视频信息记录表
 * @author zly
 * @date 2019/11/03
 */
@Mapper
@Repository
public interface MmVideosMapper {

    /**
     * [新增]
     * @author zly
     * @date 2019/11/03
     **/
    int insert(MmVideos mmVideos);

    /**
     * [刪除]
     * @author zly
     * @date 2019/11/03
     **/
    int delete(int id);

    /**
     * [更新]
     * @author zly
     * @date 2019/11/03
     **/
    int update(MmVideos mmVideos);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author zly
     * @date 2019/11/03
     **/
    MmVideos load(int id);


}
