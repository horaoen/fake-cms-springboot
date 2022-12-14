package com.example.fakecms.autoconfigure.exception;

import com.example.fakecms.autoconfigure.bean.Code;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends HttpException {

    private static final long serialVersionUID = 865571132800721223L;

    protected int code = Code.FORBIDDEN.getCode();

    protected int httpCode = HttpStatus.FORBIDDEN.value();


    public ForbiddenException() {
        super(Code.FORBIDDEN.getCode(), Code.FORBIDDEN.getDescription());
        super.ifDefaultMessage=true;
    }

    public ForbiddenException(int code) {
        super(code, Code.FORBIDDEN.getDescription());
        this.code = code;
        super.ifDefaultMessage=true;
    }

    @Deprecated
    public ForbiddenException(String message, int code) {
        super(message, code);
        this.code = code;
    }

    public ForbiddenException(int code, String message) {
        super(code, message);
        this.code = code;
    }

    public ForbiddenException(String message) {
        super(message);
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public int getHttpCode() {
        return httpCode;
    }
}