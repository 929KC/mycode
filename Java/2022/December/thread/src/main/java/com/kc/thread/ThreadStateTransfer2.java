package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/16 17:24
 * @description:
 */
public class ThreadStateTransfer2 {
    private  static Object object = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized(object) {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");
        t1.start();
        Thread t2 = new Thread(()->{
            synchronized(object) {
                System.out.println("Hello World");
            }
        },"t2");
        t2.start();
    }
}
