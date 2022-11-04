package com.example.fakecms.core.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    public static String getMethodAndUrl(HttpServletRequest request) {
        return request.getMethod() + " " + request.getServletPath();
    }


    public static HttpServletRequest getSimpleMethod(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

//    public static String getSimpleRequest() {
//        HttpServletRequest request = getRequest();
//        if (request == null) {
//            return null;
//        }
//        return request.getMethod() + " " + request.getServletPath();
//    }

    public static String getSimpleRequest() {
        HttpServletRequest request = getSimpleMethod();
        if (request == null) {
            return null;
        }
        return request.getMethod() + " " + request.getServletPath();
    }
}
