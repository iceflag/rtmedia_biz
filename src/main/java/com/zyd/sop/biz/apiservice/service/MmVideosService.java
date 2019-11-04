package com.zyd.sop.biz.apiservice.service;

import com.zyd.sop.biz.apiservice.mapper.MmImagesMapper;
import com.zyd.sop.biz.apiservice.mapper.MmVideosMapper;
import com.zyd.sop.biz.apiservice.model.MmImages;
import com.zyd.sop.biz.apiservice.model.MmVideos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 信息记录表
 * @author zly
 * @date 2019/11/03
 */
@Service
public class MmVideosService {

    @Autowired
            private MmVideosMapper mmVideosMapper;
    /**
     * [新增]
     * @author zly
     * @date 2019/11/03
     **/
    int insert(MmVideos mmVideos){
        return mmVideosMapper.insert(mmVideos);
    }

    /**
     * [刪除]
     * @author zly
     * @date 2019/11/03
     **/
    int delete(int id){
        return mmVideosMapper.delete(id);
    }

    /**
     * [更新]
     * @author zly
     * @date 2019/11/03
     **/
    int update(MmVideos mmVideos){
        return mmVideosMapper.update(mmVideos);
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author zly
     * @date 2019/11/03
     **/
    MmVideos load(int id){
        return mmVideosMapper.load(id);
    }

}
