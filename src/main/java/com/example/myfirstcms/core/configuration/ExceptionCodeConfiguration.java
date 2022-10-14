package com.example.myfirstcms.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "lin")
@PropertySource(value = "classpath:code-message.properties", encoding = "UTF-8")
public class ExceptionCodeConfiguration {

    private static Map<Integer, String> codeMessage = new HashMap<>();

    //拿到数据，数组对应
    public static String getMessage(Integer code) {
        return codeMessage.get(code);
    }

    //返回map
    public Map<Integer, String> getCodeMessage() {
        return codeMessage;
    }

    //设置一对
    public void setCodeMessage(Map<Integer, String> codeMessage) {
        ExceptionCodeConfiguration.codeMessage = codeMessage;
    }
}
