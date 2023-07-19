package org.example.thread;

import java.util.concurrent.TimeUnit;

public class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                NeedCleanup n1 = new NeedCleanup(1);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    NeedCleanup n2 = new NeedCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 1; i < 250000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                            System.out.println("Finished time-consuming operation");
                        }
                    } finally {
                        n2.cleanup();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Exiting via InterruptedException");
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exiting via while test");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
