package com.zyd.sop.biz.config;


import com.zyd.sop.servercommon.bean.ServiceConfig;
import com.zyd.sop.servercommon.configuration.AlipayServiceConfiguration;
import com.zyd.sop.servercommon.swagger.SwaggerSupport;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 使用支付宝开放平台功能
 * @author tanghc
 */
@Configuration
public class OpenServiceConfig extends AlipayServiceConfiguration {




    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


    /**
     * 开启文档
     * http://ip:port/v2/api-docs
     */
    @Configuration
    @EnableSwagger2
    public static class Swagger2 extends SwaggerSupport {
        @Override
        protected String getDocTitle() {
            return "水文API";
        }

        @Override
        protected boolean swaggerAccessProtected() {
            return false;
        }
    }
}


