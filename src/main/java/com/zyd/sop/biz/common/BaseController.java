package com.zyd.sop.biz.common;

import com.github.pagehelper.PageInfo;
import com.zyd.sop.biz.system.page.CustomerPageInfo;
import com.zyd.sop.biz.system.page.TableDataInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ControllerAdvice
@RestController
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

//    @ExceptionHandler(value = Exception.class)
//    public Object globalExceptionHandle(Exception e) {
//        logger.error("发生异常:", e);
//        throw new ServiceException("非常抱歉,服务异常,请稍后再试");
//    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable( List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRecords(list);
        CustomerPageInfo cpi= new CustomerPageInfo(new PageInfo(list));
        rspData.setPage(cpi);
        return rspData;
    }

}
