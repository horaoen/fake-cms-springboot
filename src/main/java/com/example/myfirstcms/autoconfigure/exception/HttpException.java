package com.example.myfirstcms.autoconfigure.exception;

import com.example.myfirstcms.autoconfigure.bean.Code;
import com.example.myfirstcms.autoconfigure.interfaces.BaseResponse;
import org.springframework.http.HttpStatus;

/**
 * HttpException 异常类
 * 含异常信息 message
 * http状态码 httpCode
 * 错误码 code
 *
 */
public class HttpException extends RuntimeException implements BaseResponse {

    private static final long serialVersionUID = 2359767895161832954L;

    //拿到http状态码 500
    protected int httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

    //拿到Code码里的错误码 9999 服务器未知错误
    protected int code = Code.INTERNAL_SERVER_ERROR.getCode();
    protected boolean messageOnly;
    /**
     * 是否是默认消息
     * true： 没有通过构造函数传入 message
     * false：通过构造函数传入了 message
     *
     * 没有用 isDefaultMessage 是因为和部分 rpc 框架存在兼容问题
     */
    protected boolean ifDefaultMessage  = true;

    //返回Code里的错误信息
    public HttpException() {
        super(Code.INTERNAL_SERVER_ERROR.getDescription());
    }

    public HttpException(String message) {
        super(message);
        this.ifDefaultMessage = false;
    }

    public HttpException(int code) {
        super(Code.INTERNAL_SERVER_ERROR.getDescription());
        this.code = code;
    }

    public HttpException(int code, int httpCode) {
        super(Code.INTERNAL_SERVER_ERROR.getDescription());
        this.httpCode = httpCode;
        this.code = code;
    }

    @Deprecated
    public HttpException(String message, int code) {
        super(message);
        this.code = code;
        this.ifDefaultMessage = false;
    }

    @Deprecated
    public HttpException(String message, int code, int httpCode) {
        super(message);
        this.httpCode = httpCode;
        this.code = code;
        this.ifDefaultMessage = false;
    }

    public HttpException(int code, String message) {
        super(message);
        this.code = code;
        this.ifDefaultMessage = false;
    }

    public HttpException(int code, String message, int httpCode) {
        super(message);
        this.code = code;
        this.httpCode = httpCode;
        this.ifDefaultMessage = false;
    }

    public HttpException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public HttpException(Throwable cause, int code, int httpCode) {
        super(cause);
        this.code = code;
        this.httpCode = httpCode;
    }

    public HttpException(String message, Throwable cause) {
        super(message, cause);
        this.ifDefaultMessage = false;
    }



    public Throwable doFillInStackTrace() {
        return super.fillInStackTrace();
    }

    @Override
    public int getHttpCode() {
        return this.httpCode;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    public boolean ifDefaultMessage() {
        return this.ifDefaultMessage;
    }

    public boolean isMessageOnly() {
        return this.messageOnly;
    }
}
