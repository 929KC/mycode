package org.example.thread.juc;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReaderWriterListTest {
    private static final int SIZE = 100;
    private static ExecutorService exec = Executors.newCachedThreadPool();
    private static ReaderWriterList<Integer> list = new ReaderWriterList<>(SIZE);

    public static void main(String[] args) {
        int readers = 30;
        int writers = 1;
        for (int i = 0; i < writers; i++) {
            exec.execute(new Writer(list));
        }
        for (int i = 0; i < readers; i++) {
            exec.execute(new Reader(list,SIZE));
        }
        exec.shutdown();
    }
}
