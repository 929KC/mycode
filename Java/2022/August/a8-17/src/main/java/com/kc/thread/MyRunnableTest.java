package com.kc.thread;

public class MyRunnableTest {
    public static void main(String[] args) {
      MyRunnable m =new MyRunnable();
        Thread t = new Thread(m);
        t.run();
         for (int i=0; i<10; i++) {
            int time = (int) (Math.random()*1000);
            try {
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
