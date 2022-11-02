package com.example.myfirstcms.infrastructure.dict.annotation;

import java.lang.annotation.*;

//TODO 用在dto字段上， 根据这个注解 aop 获取 相应字段key值，从dictdata中查到其value并放回给前端
//TODO 这个字段可以叫 {fieldName} + "_dictText"。
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dict {
    String dictCode() default "";
}
