package com.example.myfirstcms.vo;


import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.*;
import org.apache.catalina.util.RequestUtil;
import org.springframework.stereotype.Service;

/**
 * 统一API响应结果封装
 *@author scy
 */
@Data
@Builder
@AllArgsConstructor
public class UnifyResponseVO<T> {

    private Integer code;

    private T message;

    private String request;

    public UnifyResponseVO() {
    }


}
