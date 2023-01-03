package com.kc.thread3;

public class MyThread  extends Thread{
    public  MyThread(){
        System.out.println("构造方法开始:");
        System.out.println("构造方法:"+ Thread.currentThread().getName());
        System.out.println("构造方法:"+Thread.currentThread().isAlive());
        System.out.println("this:"+this.getName());
        System.out.println("this:"+this.isAlive());
        System.out.println("构造方法结束:");
    }
    @Override
    public void run() {
        System.out.println("run方法开始:");
        System.out.println("run方法:"+ Thread.currentThread().getName());
        System.out.println("run方法:"+Thread.currentThread().isAlive());
        System.out.println("this:"+this.getName());
        System.out.println("this:"+this.isAlive());
        System.out.println("run结束");
    }
}
