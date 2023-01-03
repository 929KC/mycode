package com.bit.thread;

public class Flag {
    private  static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while (flag) {
                System.out.println("Hello World");
            }
            System.out.println("线程结束");
        });
        t.start();
        Thread.sleep(10000);
        flag = false;
        System.out.println("main线程");
    }
}
