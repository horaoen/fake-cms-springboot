package com.example.fakecms.core.interceptor;

import com.example.fakecms.core.utils.LocalUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(isRequestForSwagger(request)){
            return true;
        }
        //TODO skip auth while dev env
        return true;
//        String token = request.getHeader("token");
//        try {
//            DecodedJWT verify = JWTUtils.verify(token);//验证令牌
//            String id = verify.getClaim("id").asString();
//            int int_id = Integer.parseInt(id);
//            UserMapper userMapper = ApplicationContextPro.getBean(UserMapper.class);
//            UserDO userDO = userMapper.queryById(int_id);
//            LocalUser.setLocalUser(userDO);
////            System.out.println(LocalUser.getLocalUser());
//            return true;//放行请求
//        }catch (SignatureVerificationException e) {
//            e.printStackTrace();
//            throw new HttpException(5001);
//        }catch (TokenExpiredException e){
//            e.printStackTrace();
//            throw new HttpException(5002);
//        }catch (AlgorithmMismatchException e){
//            e.printStackTrace();
//            throw new HttpException(5003);
//        }catch (Exception e){
//            e.printStackTrace();
//            throw new Exception();
//        }
    }

    private boolean isRequestForSwagger(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/swagger-ui")
                || request.getRequestURI().startsWith("/v3/api-docs");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocalUser.clearLocalUser();
    }
}


