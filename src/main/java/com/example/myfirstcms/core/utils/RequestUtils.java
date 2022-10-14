package com.example.myfirstcms.core.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    public static String getMethodAndUrl(HttpServletRequest request) {
        return request.getMethod() + " " + request.getServletPath();
    }
}
