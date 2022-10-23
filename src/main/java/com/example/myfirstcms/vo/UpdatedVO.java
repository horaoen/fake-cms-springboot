package com.example.myfirstcms.vo;

import com.example.myfirstcms.autoconfigure.bean.Code;
import com.example.myfirstcms.core.utils.ResponseUtils;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.http.HttpStatus;

public class UpdatedVO extends UnifyResponseVO<String> {

    public UpdatedVO() {
        super(Code.UPDATED.getCode());
        ResponseUtils.setCurrentResponseHttpStatus(HttpStatus.OK.value());
    }

    public UpdatedVO(int code) {
        super(code);
        ResponseUtils.setCurrentResponseHttpStatus(HttpStatus.OK.value());
    }

    public UpdatedVO(String message) {
        super(message);
        ResponseUtils.setCurrentResponseHttpStatus(HttpStatus.OK.value());
    }

    public UpdatedVO(int code, String message) {
        super(code, message);
        ResponseUtils.setCurrentResponseHttpStatus(HttpStatus.OK.value());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
