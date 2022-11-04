package com.example.myfirstcms.infrastructure.dict.aop;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.myfirstcms.infrastructure.dict.annotation.Dict;
import com.example.myfirstcms.infrastructure.dict.mapper.DictMapper;
import com.example.myfirstcms.vo.UnifyResponseVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@Aspect
public class DictAspect {

    private static final String TextSUFFIX = "_dictText";

    private final DictMapper dictMapper;

    public DictAspect(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    @Pointcut("@annotation(com.example.myfirstcms.infrastructure.dict.annotation.Dict)")
    public void dictPointCut() {

    }

    @Around("dictPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();
        if (ObjectUtil.isNull(result)) {
            return result;
        }
        Object resultTrans = ((UnifyResponseVO) result).getMessage();
        resultTrans = translate(resultTrans);
        ((UnifyResponseVO) result).setMessage(resultTrans);
        return result;
    }

    private Object translate(Object result) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{}";
        try {
            json = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        JSONObject item = JSONObject.parseObject(json);
        Field[] fields = this.getAllFields(result);
        for (Field field : fields) {
            if (field.getAnnotation(Dict.class) != null) {
                //获取注解,获取注解字段key值，获取返回注解解析值，获取value值
                String code = field.getAnnotation(Dict.class).dictCode();
                String key = String.valueOf(item.get(field.getName()));
                String text = code + TextSUFFIX;
                String text_value = translateDictValue(code, key);
                if (!StringUtils.isEmpty(text)) {
                    item.put(text, text_value);
                }
            }
        }
        return item;
    }

    private String translateDictValue(String code, String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        String DictValue = this.dictMapper.queryDictValueByKey(code, key);
        return DictValue;
    }

    public Field[] getAllFields(Object object) {
        Class clazz = object.getClass();
        List<Field> fieldsList = new ArrayList<>();
        while (clazz != null) {
            fieldsList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldsList.size()];
        fieldsList.toArray(fields);
        return fields;
    }

}
