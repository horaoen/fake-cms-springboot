package com.example.myfirstcms.core.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.myfirstcms.autoconfigure.exception.HttpException;
import com.example.myfirstcms.core.utils.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中令牌
        String token = request.getHeader("token");
        try {
            JWTUtils.verify(token);//验证令牌
            return true;//放行请求
        }catch (SignatureVerificationException e) {
            e.printStackTrace();
            throw new HttpException(5001);
        }catch (TokenExpiredException e){
            e.printStackTrace();
            throw new HttpException(5002);
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            throw new HttpException(5003);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }
}


