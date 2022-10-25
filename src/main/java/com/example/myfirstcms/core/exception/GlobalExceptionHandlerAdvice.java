package com.example.myfirstcms.core.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.example.myfirstcms.autoconfigure.bean.Code;
import com.example.myfirstcms.autoconfigure.exception.HttpException;
import com.example.myfirstcms.core.configuration.ExceptionCodeConfiguration;
import com.example.myfirstcms.core.utils.RequestUtils;
import com.example.myfirstcms.vo.UnifyResponseVO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static com.example.myfirstcms.core.utils.RequestUtils.getMethodAndUrl;
import static com.example.myfirstcms.core.utils.RequestUtils.getSimpleMethod;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    private UnifyResponseVO<Map<String, Object>> getMapUnifyResponseVO(HttpServletRequest request,
                                                                       HttpServletResponse response,
                                                                       Map<String, Object> msg) {
        UnifyResponseVO<Map<String, Object>> unifyResponse = new UnifyResponseVO<>();
        unifyResponse.setRequest(RequestUtils.getMethodAndUrl(request));
        unifyResponse.setMessage(msg);
        unifyResponse.setCode(Code.PARAMETER_ERROR.getCode());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return unifyResponse;
    }

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


    /**
     * 说实话没看懂异常怎么处理的，异常格式是map
     * 普通参数(非 java bean)校验出错时抛出 ConstraintViolationException 异常
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public UnifyResponseVO<Map<String, Object>> processException(ConstraintViolationException exception,
                                                                 HttpServletRequest request,
                                                                 HttpServletResponse response) {
        Map<String, Object> msg = new HashMap<>();
        exception.getConstraintViolations().forEach(constraintViolation -> {
            String template = constraintViolation.getMessage();
            String path = constraintViolation.getPropertyPath().toString();
            msg.put(com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(path), template);
        });
        return getMapUnifyResponseVO(request, response, msg);
    }

    /**
     * 将请求体解析并绑定到 java bean 时，如果出错，则抛出 MethodArgumentNotValidException 异常
     * params 绑定到 java bean 出错时抛出 BindException 异常
     * MethodArgumentNotValidException extends BindException，所以只要处理BindException
     */
    @ExceptionHandler({BindException.class})
    public UnifyResponseVO<Map<String, Object>> processException(BindException exception,
                                                                 HttpServletRequest request,
                                                                 HttpServletResponse response) {
        Map<String, Object> msg = new HashMap<>();
        exception.getAllErrors().forEach(error -> {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                msg.put(com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(fieldError.getField()),
                        fieldError.getDefaultMessage());
            } else {
                msg.put(com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(error.getObjectName()),
                        error.getDefaultMessage());
            }
        });
        return getMapUnifyResponseVO(request, response, msg);
    }
}

