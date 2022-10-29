package com.example.myfirstcms.core.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class ResultAspect {
    @AfterReturning(returning = "result", pointcut = "execution(* com.example.myfirstcms.controller.*.*(..))")
    public void doAfterReturning(String result) {
       return ;
    }
}
