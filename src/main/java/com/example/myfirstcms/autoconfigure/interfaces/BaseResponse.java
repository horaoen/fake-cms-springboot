package com.example.myfirstcms.autoconfigure.interfaces;

public interface BaseResponse {

    /**
     * 返回的信息
     *
     * @return 返回的信息
     */
    String getMessage();

    /**
     * http 状态码
     *
     * @return http 状态码
     */
    int getHttpCode();

    /**
     * 错误码
     *
     * @return 错误码
     */
    int getCode();
}
