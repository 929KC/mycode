package com.bit.thread;

/**
 * 注意:加锁的对象,和调用wait的对象得是同一个对象,还要保证,
 * 调用wait的对象和调用notify的对象,也是同一个对象
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (o) {
                    System.out.println("wait前");
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait后");
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(() -> {
            while (true) {
              synchronized (o) {
                  System.out.println("notify之前");
                  o.notify();
                  System.out.println("notify之后");
                  try {
                      Thread.sleep(10000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
            }
        });
        t2.start();
    }
}
