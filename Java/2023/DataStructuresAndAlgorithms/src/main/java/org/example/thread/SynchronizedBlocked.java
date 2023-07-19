package org.example.thread;

/**
 * 不可中断
 */
public class SynchronizedBlocked implements Runnable {
    @Override
    public void run() {
        System.out.println("trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
    public synchronized void f(){
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(){
            @Override
            public void run() {
                f();
            }
        }.start();
    }
}
