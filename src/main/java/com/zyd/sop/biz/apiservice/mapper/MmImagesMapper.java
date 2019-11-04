package com.zyd.sop.biz.apiservice.mapper;

import com.zyd.sop.biz.apiservice.model.MmImages;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 图片信息记录表
 * @author zly
 * @date 2019/11/03
 */
@Mapper
@Repository
public interface MmImagesMapper {

    /**
     * [新增]
     * @author zly
     * @date 2019/11/03
     **/
    int insert(MmImages mmImages);

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
    int update(MmImages mmImages);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author zly
     * @date 2019/11/03
     **/
    MmImages load(int id);



}
