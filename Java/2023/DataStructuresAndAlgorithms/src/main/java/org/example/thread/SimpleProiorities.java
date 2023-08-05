package org.example.thread;


public class SimpleProiorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimpleProiorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    @Override
    public void run() {
        //设置优先级
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 1; i < 100000; i++) {
                d = (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SimpleProiorities(Thread.MIN_PRIORITY));
            Thread t1 = new Thread(new SimpleProiorities(Thread.MAX_PRIORITY));
            t.start();
            t1.start();
        }
    }
}
