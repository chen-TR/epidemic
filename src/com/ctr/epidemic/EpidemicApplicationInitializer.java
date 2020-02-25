package com.ctr.epidemic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/2/25 12:42
 */
public class EpidemicApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //spring的配置类
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //spring-mvc的配置类
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //返回映射到dispatcherServlet的请求路径
        return new String[]{"/"};
    }
}
