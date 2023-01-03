package com.kc.mythread;

public class Run2 {
    public static void main(String[] args) {
        MyThread m = new MyThread();
        try {
            m.start();
            Thread.sleep(2000);
            m.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");
    }
}
