package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/5 8:22
 * @description: '
 */
public class Demo {

    public static  class MyThread extends Thread {
        @Override
            public void run() {
                System.out.println("Hello Wolrd");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
