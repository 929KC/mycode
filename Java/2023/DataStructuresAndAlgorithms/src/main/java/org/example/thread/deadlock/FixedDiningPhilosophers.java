package org.example.thread.deadlock;

import java.util.concurrent.*;

public class FixedDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[5];
        int size = 5;
        for (int i = 0; i < sticks.length; i++) {
            sticks[i] = new Chopstick(i + "号筷子");
        }
        for (int i = 0; i < sticks.length; i++) {
            //前四个哲学家
            if (i < (size - 1)) {
                exec.execute(new Philosopher(sticks[i], sticks[(i + 1)], i + "哲学家"));
            } else {
                exec.execute(new Philosopher(sticks[0], sticks[(i)], i + "哲学家"));
            }
        }
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
