package com.zyd.sop.biz.system.page;

import com.github.pagehelper.PageInfo;
import lombok.Data;

@Data
public class CustomerPageInfo {
    /** 总记录数 */
    private long total;
    private int pageSize;
    private int pageNumber;
    public CustomerPageInfo(){

    }
    public CustomerPageInfo(PageInfo<?> pageInfo){
        this.total=pageInfo.getTotal();
        this.pageSize=pageInfo.getPageSize();
        this.pageNumber = pageInfo.getPageNum();
    }
}
