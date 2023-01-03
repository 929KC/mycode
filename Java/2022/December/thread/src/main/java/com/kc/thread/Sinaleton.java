package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/17 10:17
 * @description:
 */
public class Sinaleton {
    private static Sinaleton singal = new Sinaleton();
    public static Sinaleton getInstance() {
        return singal;
    }
}
