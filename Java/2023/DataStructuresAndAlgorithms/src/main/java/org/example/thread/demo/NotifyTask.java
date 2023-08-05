package org.example.thread.demo;

public class NotifyTask implements Runnable {
    private Object lock;

    public NotifyTask(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("你们好,我是:"+Thread.currentThread().getName());
            lock.notifyAll();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new WaitTask(lock),"贾宝玉");
        Thread t2 = new Thread(new WaitTask(lock),"妙玉");
        Thread t3 = new Thread(new WaitTask(lock),"史湘云");
        Thread t4 = new Thread(new NotifyTask(lock),"林黛玉");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(2000);
        t4.start();
    }
}
