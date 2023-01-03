package com.kc.thread;

public class MyThread extends Thread {
    private int count =10;
    public MyThread(String name) {
        this.setName(name);
    }
    @Override
    public void run() {

       while(count>0){
           System.out.println("count:"+this.getName()+","+count);
           count--;
       }
    }
}
