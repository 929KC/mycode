package com.kc.thread;


public class MyThread2  extends Thread{
   private  int  count = 5;
    @Override
    public void run() {
         count--;
        System.out.println(this.currentThread().getName()+","+count);
    }
}
