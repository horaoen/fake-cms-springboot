package com.example.myfirstcms.core.configuration;

import com.example.myfirstcms.core.interceptor.AuthenticationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class GlobalWebMvcConfig implements WebMvcConfigurer {

    /**
     *添加拦截器
     *@param registry
     */
    @Override   public void addInterceptors(InterceptorRegistry registry)
    {
        //添加权限拦截器
        registry.addInterceptor(new AuthenticationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");
    }
}