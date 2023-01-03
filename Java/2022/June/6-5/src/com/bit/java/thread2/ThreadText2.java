package com.bit.java.thread2;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 16:10
 */

public class ThreadText2 {
    public static void main(String[] args) {
        Thread t=new Thread(new Mythread2());
        t.start();
        for (int i=0; i<10000; i++){
            System.out.println("main"+i);
        }
    }
}

class Mythread2 implements Runnable{
    @Override
    public void run() {
       for (int i = 0; i <10000;i++){
           Thread.yield();
           System.out.println("分支线程"+i);
       }
    }
}