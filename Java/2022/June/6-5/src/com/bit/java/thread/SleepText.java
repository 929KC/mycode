package com.bit.java.thread;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 14:46
 */

/**
 * 当前线程休眠,sleep 静态方法
 */
public class SleepText {
    public static void main(String[] args) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World");
    }

}
