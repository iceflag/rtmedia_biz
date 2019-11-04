package com.zyd.sop.biz.system.page;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 * 
 * @author
 */
public class TableDataInfo<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private CustomerPageInfo page;

    /** 列表数据 */
    private List<T> records;

    /**
     * 表格数据对象
     */
    public TableDataInfo()
    {
    }

    /**
     * 分页
     * 
     * @param records 列表数据
     * @param page 分页信息
     */
    public TableDataInfo(List<T> records, CustomerPageInfo page)
    {
        this.records = records;
        this.page = page;
    }

    public CustomerPageInfo getPage() {
        return page;
    }

    public void setPage(CustomerPageInfo page) {
        this.page = page;
    }

    public List<?> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
