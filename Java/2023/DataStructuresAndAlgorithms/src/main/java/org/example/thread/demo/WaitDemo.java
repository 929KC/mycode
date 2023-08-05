package org.example.thread.demo;



public class WaitDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
              synchronized (this) {
                  System.out.println("你好,我是:"+Thread.currentThread().getName());
                  try {
                      System.out.println("等待林妹妹回复");
                       wait();
                      System.out.println("林妹妹回复我了");
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
              }
            }
        },"贾宝玉");
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("你好,我是:"+Thread.currentThread().getName());
                    notifyAll();
                }
            }
        },"林黛玉");
        t2.start();
    }
}
