package com.kc.thread3;

public class MyThreadTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread m = new MyThread();
        //System.out.println("begin:"+m.isAlive());
       m.start();
        System.out.println(m.getId());
        //m.sleep(100);
        //System.out.println("end:"+m.isAlive());
        Thread main = Thread.currentThread();
        System.out.println(main.getId());
    }
}
