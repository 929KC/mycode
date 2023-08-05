package org.example.thread.bit3;

import java.util.concurrent.LinkedBlockingQueue;

public class Worker extends Thread {
    private LinkedBlockingQueue<Runnable> queue = null;

    public Worker(LinkedBlockingQueue<Runnable> queue) {
        super("worker");
        this.queue = queue;
    }

    @Override
    public void run() {
        // try 必须放在 while 外头, 或者 while 里头应该影响不大
        try {
            while (!Thread.interrupted()) {
                Runnable runnable = queue.take();
                runnable.run();
            }
        } catch (InterruptedException e) {
        }
    }
}