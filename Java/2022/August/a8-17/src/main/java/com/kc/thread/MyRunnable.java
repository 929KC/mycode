package com.kc.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
         for (int i = 0; i <10;i++) {
            int time = (int) (Math.random() *1000);
           try {
               Thread.sleep(time);
               System.out.println(Thread.currentThread().getName());
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }

    }
}
