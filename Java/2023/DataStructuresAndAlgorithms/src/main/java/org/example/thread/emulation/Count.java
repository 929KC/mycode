package org.example.thread.emulation;

import java.util.Random;

public class Count {
    private int count = 0;
    private Random random = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return (count=++temp);
    }

    public synchronized int value() {
        return count;
    }

}
