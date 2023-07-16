package org.example.thread;

import java.util.concurrent.TimeUnit;

public class Daemon implements Runnable{
    private Thread  [] t = new Thread[10];
    @Override
    public void run() {
        for (int i=0;i<t.length;i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn"+i+" started");
        }
        for (int i=0;i<t.length;i++) {
            System.out.println("t["+i+"]+.isDaemon() = "+t[i].isDaemon());
        }
        while (true) {
            Thread.yield();
        }
    }

    /**
     * Daemon线程被设置成了后台模式，
     * 然后派生出许多子线程，这些线程并没有被显式地设置为后台模式，
     * 不过它们的确是后台线程
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        System.out.println("t.isdaemon() = "+t.isDaemon());
        TimeUnit.SECONDS.sleep(1);
    }
}
