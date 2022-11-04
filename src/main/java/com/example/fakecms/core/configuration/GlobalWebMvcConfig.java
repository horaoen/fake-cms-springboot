package com.example.fakecms.core.configuration;

import com.example.fakecms.core.interceptor.AuthenticationInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Configuration
public class GlobalWebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置跨域
     * @Param registry
     * */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//
                .allowedOrigins("*")//
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")//
                .maxAge(3600)//
                .allowCredentials(true);
    }

    /**
     * 处理返回中文乱码
     * @Param converters
     *
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 解决controller返回字符串中文乱码问题
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
            } else if (converter instanceof MappingJackson2HttpMessageConverter) {
                ((MappingJackson2HttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
    }

    /**
     * 配置校验文件
     *
     * */
    @Override
    public Validator getValidator() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("utf-8");// 读取配置文件的编码格式
        messageSource.setCacheMillis(-1);// 缓存时间，-1表示不过期
        messageSource.setBasename("ValidationMessages");// 配置文件前缀名，设置为Messages,那你的配置文件必须以Messages.properties/Message_en.properties...

        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        factoryBean.setValidationMessageSource(messageSource);
        return factoryBean;
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
                .excludePathPatterns("/user/login");
    }
}