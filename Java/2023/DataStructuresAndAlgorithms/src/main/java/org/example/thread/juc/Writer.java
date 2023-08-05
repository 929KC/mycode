package org.example.thread.juc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Writer implements Runnable{
    private static Random rand = new Random(47);
    private ReaderWriterList<Integer> list ;

    public Writer(ReaderWriterList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            list.set(i, rand.nextInt());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("writer finished shutting down");
        }
    }
}
