package com.kc.mythread;

public class Run {
    public static void main(String[] args) {
        try {
            MyThread m = new MyThread();
            m.start();
            Thread.sleep(1000);
           m.interrupt();
            //Thread.currentThread().interrupt();
            System.out.println("是否中断1:"+m.isInterrupted());
            System.out.println("是否中断2:"+m.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
