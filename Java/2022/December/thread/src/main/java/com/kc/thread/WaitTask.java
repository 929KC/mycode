package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/16 20:50
 * @description:
 */
public class WaitTask implements Runnable {
    private Object object;

    public WaitTask(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            while (true) {
                try {
                    System.out.println("wait开始");
                    object.wait();
                    System.out.println("wait结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class NotufyTask implements Runnable {
        private Object object;

        public NotufyTask(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("notif开始");
                object.notifyAll();
                System.out.println("notify结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new WaitTask(lock));
        Thread t2 = new Thread(new WaitTask(lock));
        Thread t3 = new Thread(new WaitTask(lock));
        Thread t4 = new Thread(new WaitTask(lock));
        Thread t5 = new Thread(new NotufyTask(lock));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.sleep(1000);
        t5.start();
    }
}
