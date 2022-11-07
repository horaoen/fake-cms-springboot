package com.example.fakecms.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public DateUtil() {
    }

    public static Date getDurationDate(long duration) {
        long expireTime = System.currentTimeMillis() + duration * 1000L;
        return new Date(expireTime);
    }

    public static String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String format = formatter.format(date);
        return format;
    }
}
