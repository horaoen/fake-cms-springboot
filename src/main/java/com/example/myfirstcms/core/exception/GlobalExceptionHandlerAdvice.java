package com.example.myfirstcms.core.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.example.myfirstcms.autoconfigure.bean.Code;
import com.example.myfirstcms.autoconfigure.exception.HttpException;
import com.example.myfirstcms.core.configuration.ExceptionCodeConfiguration;
import com.example.myfirstcms.vo.UnifyResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.InvocationTargetException;

import static com.example.myfirstcms.core.utils.RequestUtils.getMethodAndUrl;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    /**
     * Exception
     * */
    @ExceptionHandler({Exception.class})
    public UnifyResponseVO<String> processException(Exception exception,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) {
        UnifyResponseVO<String> result = new UnifyResponseVO<>();
        result.setRequest(getMethodAndUrl(request));
        result.setMessage(Code.INTERNAL_SERVER_ERROR.getZhDescription());
        result.setCode(Code.INTERNAL_SERVER_ERROR.getCode());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return result;
    }


    /**
     * HttpException
     */
    @ExceptionHandler({HttpException.class})
    public UnifyResponseVO<String> processException(HttpException exception,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        UnifyResponseVO<String> unifyResponse = new UnifyResponseVO<>();
        unifyResponse.setRequest(getMethodAndUrl(request));
        int code = exception.getCode();
        unifyResponse.setCode(code);
        response.setStatus(exception.getHttpCode());
        String errorMessage = ExceptionCodeConfiguration.getMessage(code);
        if (!StringUtils.hasText(errorMessage)) {
            unifyResponse.setMessage(exception.getMessage());
        } else {
            unifyResponse.setMessage(errorMessage);
        }
        return unifyResponse;
    }


}

