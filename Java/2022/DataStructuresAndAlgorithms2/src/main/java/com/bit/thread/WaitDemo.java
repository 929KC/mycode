package com.bit.thread;

/**
 * IllegalMonitorStateException:锁状态异常
 * wait的本质
 * 1.释放当前的锁
 * 2.进行等待通知
 * 3.满足一定条件的时候(别人调用notify时)被唤醒,然后尝试重新获取锁
 * 等待通知的前提,是要先释放锁,而释放锁的前提,是你得加了锁
 */
public class WaitDemo {
    public static void main(String[] args) {
        Object o = new Object();
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
}
