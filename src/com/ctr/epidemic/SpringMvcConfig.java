package com.ctr.epidemic;

import com.ctr.epidemic.common.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/2/25 13:25
 * extends W..Adapter ->避免实现WebMvcConfigurer接口的所有方法
 */
@Configuration
@EnableWebMvc
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class))
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private DateConverter dateConverter;

    //配置视图映射器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("epidemic");
    }

    //配置内部资源视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/",".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
