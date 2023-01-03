package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/5 8:27
 * @description:
 */
public class Demo2 {
    public  static  class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
    }
}
