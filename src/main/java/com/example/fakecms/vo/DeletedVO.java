package com.example.fakecms.vo;

import com.example.fakecms.autoconfigure.bean.Code;
import com.example.fakecms.core.utils.ResponseUtils;
import org.springframework.http.HttpStatus;

/**
 * @author colorful@TaleLin
 */
public class DeletedVO extends UnifyResponseVO<String> {

    public DeletedVO() {
        super(Code.DELETED.getCode());
        ResponseUtils.setCurrentResponseHttpStatus(HttpStatus.OK.value());
    }

    public DeletedVO(int code) {
        super(code);
        ResponseUtils.setCurrentResponseHttpStatus(HttpStatus.OK.value());
    }

    public DeletedVO(String message) {
        super(message);
        ResponseUtils.setCurrentResponseHttpStatus(HttpStatus.OK.value());
    }

    public DeletedVO(int code, String message) {
        super(code, message);
        ResponseUtils.setCurrentResponseHttpStatus(HttpStatus.OK.value());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
