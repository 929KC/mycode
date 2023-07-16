package org.example.thread;

import java.util.concurrent.ThreadFactory;



public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonThreadFactory daemonThread = new DaemonThreadFactory();
        Thread t = daemonThread.newThread(() -> {
            while (true) {
                System.out.println("我是后台线程");
            }
        });
        t.start();
        Thread.sleep(200);
    }
}
