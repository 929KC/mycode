package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/17 10:18
 * @description:
 */
public class Singleton2 {
    public static volatile Singleton2 singal = null;
    public static Singleton2 getInstance() {
        if (singal==null) {
            synchronized (Singleton2.class) {
                singal = new Singleton2();
            }
        }
        return singal;
    }
}
