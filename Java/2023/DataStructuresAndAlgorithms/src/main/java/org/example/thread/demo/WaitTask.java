package org.example.thread.demo;

public class WaitTask implements Runnable{
    private Object lock;

    public WaitTask(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("你好,我是:"+Thread.currentThread().getName());
            try {
                System.out.println("等待林妹妹回复");
                lock.wait();
                System.out.println("林妹妹回复我了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
