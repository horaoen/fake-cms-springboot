package com.example.myfirstcms.core.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.myfirstcms.autoconfigure.exception.HttpException;
import com.example.myfirstcms.core.utils.ApplicationContextPro;
import com.example.myfirstcms.core.utils.JWTUtils;
import com.example.myfirstcms.core.utils.LocalUser;
import com.example.myfirstcms.mapper.UserMapper;
import com.example.myfirstcms.pojo.UserDO;
import com.example.myfirstcms.service.Impl.UserServiceImpl;
import com.example.myfirstcms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
            DecodedJWT verify = JWTUtils.verify(token);//验证令牌
            String id = verify.getClaim("id").asString();
            int int_id = Integer.parseInt(id);
            UserMapper userMapper = ApplicationContextPro.getBean(UserMapper.class);
            UserDO userDO = userMapper.queryById(int_id);
            LocalUser.setLocalUser(userDO);
//            System.out.println(LocalUser.getLocalUser());
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


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalUser.clearLocalUser();
    }
}


