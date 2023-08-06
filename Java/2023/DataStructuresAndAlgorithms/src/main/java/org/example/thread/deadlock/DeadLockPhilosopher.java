package org.example.thread.deadlock;

import java.io.IOException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockPhilosopher {
    public static void main(String[] args) throws InterruptedException, IOException {
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick []  sticks = new Chopstick[size];
        for (int i = 0; i < sticks.length;i++){
            sticks[i] = new Chopstick(i+"号筷子");
        }
        for (int i = 0; i < size;i++) {
            exec.execute(new Philosopher(sticks[i], sticks[(i+1) % size],i+"号哲学家"));
        }
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}
