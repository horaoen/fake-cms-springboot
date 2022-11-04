package com.example.fakecms.core.exception;

import com.example.fakecms.autoconfigure.bean.Code;
import com.example.fakecms.autoconfigure.exception.HttpException;
import com.example.fakecms.core.configuration.ExceptionCodeConfiguration;
import com.example.fakecms.vo.UnifyResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

import static com.example.fakecms.core.utils.RequestUtils.getMethodAndUrl;

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

