package com.kc.mythread;

public class MyThreadTest {
    public static void main(String[] args) {
        MyThread m =new MyThread();
        m.start();
        try {
            Thread.sleep(2000);
            m.interrupt();
            System.out.println("线程是否停止1:"+m.interrupted());
            System.out.println("线程是否停止2:"+m.interrupted());//判断运行该方法的线程是否中断
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end!");
    }
}
