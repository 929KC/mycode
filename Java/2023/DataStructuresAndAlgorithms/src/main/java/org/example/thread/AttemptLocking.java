package org.example.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private ReentrantLock locks = new ReentrantLock();

    /**
     * ReentrantLock允许你尝试着获取但最终未获取锁，
     * 这样如果其他人已经获取了这个锁，那你就可以决定离开去执行其他一些事情，
     * 而不是等待直至这个锁被释放，
     * 就像在untimed（）方法中所看到的。
     */
    public void  untimed(){
        boolean captured = locks.tryLock();
       try {
           System.out.println("tryLock: " + captured);
       }finally {
           if (captured) {
               locks.unlock();
           }
       }

    }
    public void  timed(){
        boolean captured = false;
        try {
            //做出了尝试去获取锁，该尝试可以在2秒之后失败
            captured = locks.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock2: TimeUnit.SECONDS" + captured);
        } finally {
            if (captured) {
                locks.unlock();
            }
        }
    }

    public static void main(String[] args) {
       final AttemptLocking al = new AttemptLocking();
       al.untimed();
       al.timed();
       new Thread(){
           @Override
           public void run() {

               al.locks.lock();
               System.out.println("acquired");
           }
       }.start();
       Thread.yield();
       al.untimed();
       al.timed();
    }
}
