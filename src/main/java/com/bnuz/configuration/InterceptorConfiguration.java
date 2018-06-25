package com.bnuz.configuration;

import com.bnuz.interceptor.ActivityOperateInterceptor;
import com.bnuz.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置
 * @author QuanQqqqq
 * @date 2018-04-21
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private ActivityOperateInterceptor activityOperateInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/user/**")
                .addPathPatterns("/api/activity/**")
                .addPathPatterns("/api/admin/**")
                .excludePathPatterns("/api/user/login", "/api/user/register")
                .excludePathPatterns("/api/activity/attendent/login")
                .excludePathPatterns("/api/admin/login");

        // 加入活动拦截器
        registry.addInterceptor(activityOperateInterceptor);
    }
}