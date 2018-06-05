package com.bnuz.configuration;

import com.bnuz.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置
 * @author QuanQqqqq
 * @date 2018-04-21
 */
@Configuration
public class WebAppConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/user/**")
                .addPathPatterns("/api/activity/**")
                .addPathPatterns("/api/admin/**")
                .excludePathPatterns("/api/user/login", "/api/user/register")
                .excludePathPatterns("/api/activity/attendent/login")
                .excludePathPatterns("/api/admin/login");
    }
}