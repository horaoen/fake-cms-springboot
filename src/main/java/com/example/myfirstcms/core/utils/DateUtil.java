package com.example.myfirstcms.core.utils;

import java.util.Date;

public class DateUtil {
    public DateUtil() {
    }

    public static Date getDurationDate(long duration) {
        long expireTime = System.currentTimeMillis() + duration * 1000L;
        return new Date(expireTime);
    }
}
