package com.bit.thread;

import java.util.Random;

public class MyThread extends  Thread{
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(10));//被调用线程的名字
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 =  new MyThread();
        MyThread m3 = new MyThread();
        m1.start();
        m2.start();
        m3.start();
        Random random = new Random();
        while (true) {
            System.out.println(Thread.currentThread().getName());//main线程的名字
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
