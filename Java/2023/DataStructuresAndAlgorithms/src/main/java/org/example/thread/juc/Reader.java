package org.example.thread.juc;

import java.util.concurrent.TimeUnit;

public class Reader implements Runnable{
    private ReaderWriterList<Integer> list;
    private  final int SIZE ;

    public Reader(ReaderWriterList<Integer> list, int SIZE) {
        this.list = list;
        this.SIZE = SIZE;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i=0;i<SIZE;i++) {
                    list.get(i);
                    TimeUnit.MILLISECONDS.sleep(1);
                }
            }
        } catch (InterruptedException e) {

        }
    }
}
