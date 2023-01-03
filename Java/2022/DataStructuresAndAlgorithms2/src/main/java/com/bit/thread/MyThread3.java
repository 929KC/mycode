package com.bit.thread;

public class MyThread3 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程1号");
            }
        });
        t1.start();
        Thread.sleep(3000);
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("我是线程2号");
            }
        };
        t2.start();
        Thread.sleep(3000);
        Thread t3 = new Thread(()-> System.out.println("我是线程3号"));
        t3.start();
        Thread.sleep(3000);
        Thread t4 = new Thread(()-> System.out.println("我是线程4号"));
        t4.start();

    }
}
