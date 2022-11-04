package com.example.fakecms.vo;

import com.example.fakecms.autoconfigure.bean.Code;
import com.example.fakecms.core.utils.ResponseUtils;
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
