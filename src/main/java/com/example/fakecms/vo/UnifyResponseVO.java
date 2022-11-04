package com.example.fakecms.vo;


import com.example.fakecms.autoconfigure.bean.Code;
import com.example.fakecms.core.utils.RequestUtils;
import com.example.fakecms.core.utils.ResponseUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

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
        this.code = Code.SUCCESS.getCode();
        this.request = RequestUtils.getSimpleRequest();
    }

    public UnifyResponseVO(int code) {
        this.code = code;
        this.request = RequestUtils.getSimpleRequest();
    }

    public UnifyResponseVO(T message) {
        this.code = Code.SUCCESS.getCode();
        this.message = message;
        this.request = RequestUtils.getSimpleRequest();
    }

    public UnifyResponseVO(int code, T message) {
        this.code = code;
        this.message = message;
        this.request = RequestUtils.getSimpleRequest();
    }

    public UnifyResponseVO(T message, HttpStatus httpStatus) {
        this.code = Code.SUCCESS.getCode();
        this.message = message;
        this.request = RequestUtils.getSimpleRequest();
        ResponseUtils.setCurrentResponseHttpStatus(httpStatus.value());
    }

    public UnifyResponseVO(int code, T message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.request = RequestUtils.getSimpleRequest();
        ResponseUtils.setCurrentResponseHttpStatus(httpStatus.value());
    }
}
