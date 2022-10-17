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

    @Configuration
    public class MyMvcConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")  //设置所有的请求可以进行跨域
                    .allowedOrigins("*")  //允许跨域的ip
                    .allowedMethods("*")  //请求的方法 可以不设置 有默认的
                    .allowedHeaders("*"); //请求头 可以不设置 有默认的
        }
    }

    /**
     *添加拦截器
     *@param registry
     */
    @Override   public void addInterceptors(InterceptorRegistry registry)
    {
        //添加权限拦截器
        registry.addInterceptor(new AuthenticationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/*");
    }
}