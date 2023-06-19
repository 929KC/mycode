package com.kc.cloud_takeaway.common;



public class BaseContextUtils {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static Long getCurrentId() {
        return threadLocal.get();
    }
    public static void setCurrentId(Long id) {
         threadLocal.set(id);
    }
}
