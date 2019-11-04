package com.zyd.sop.biz.apiservice.service;

import com.zyd.sop.biz.apiservice.mapper.MmImagesMapper;
import com.zyd.sop.biz.apiservice.model.MmImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MmImagesService {

    @Autowired
            private MmImagesMapper mmImagesMapper;
    /**
     * [新增]
     * @author zly
     * @date 2019/11/03
     **/
    int insert(MmImages mmImages){
        return mmImagesMapper.insert(mmImages);
    }

    /**
     * [刪除]
     * @author zly
     * @date 2019/11/03
     **/
    int delete(int id){
        return mmImagesMapper.delete(id);
    }

    /**
     * [更新]
     * @author zly
     * @date 2019/11/03
     **/
    int update(MmImages mmImages){
        return mmImagesMapper.update(mmImages);
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author zly
     * @date 2019/11/03
     **/
    MmImages load(int id){
        return mmImagesMapper.load(id);
    }
}
