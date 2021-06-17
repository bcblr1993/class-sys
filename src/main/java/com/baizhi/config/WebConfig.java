package com.baizhi.config;

import com.baizhi.filters.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean reqResFilter() {
        //声明定义filter的注册对象
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //创建自定义filter
        LoginFilter loginFilter  = new LoginFilter();
        //设置Filter
        filterRegistrationBean.setFilter(loginFilter);
        //添加拦截规则
        filterRegistrationBean.addUrlPatterns("/clazz/findAll","/student/findAll","/city/findAll","/tag/findAll","/group/findAll","/back/main/main.jsp");
         return filterRegistrationBean;
    }
}