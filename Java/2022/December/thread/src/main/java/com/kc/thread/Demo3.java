package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/5 8:36
 * @description:
 */
public class Demo3 {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Hello Wolrd");
            }
        };
        thread.start();
    }
}
