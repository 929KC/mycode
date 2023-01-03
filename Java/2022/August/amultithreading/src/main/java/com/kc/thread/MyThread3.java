package com.kc.thread;

public class MyThread3  extends Thread{
   private int count = 3;
    @Override
    synchronized  public void run() {
        count--;
        System.out.println(this.currentThread().getName() + ": " + count);
    }
}
