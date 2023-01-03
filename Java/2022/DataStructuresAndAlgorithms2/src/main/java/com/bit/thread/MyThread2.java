package com.bit.thread;

public class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("我是一个线程");
    }

    public static void main(String[] args) {
     Thread t= new Thread(new MyThread2());
     t.start();
     for (int i = 0;i<10;i++) {
         System.out.println(i);
     }
    }
}
