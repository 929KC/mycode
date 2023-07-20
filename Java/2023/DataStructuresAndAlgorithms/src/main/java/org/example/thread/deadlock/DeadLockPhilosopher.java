package org.example.thread.deadlock;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockPhilosopher {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(Arrays.toString(args));
        int ponder = 5;
        int size = 5;
        if (args.length>0) {
            ponder = Integer.parseInt(args[0]);
        }

        if (args.length>1) {
            size = Integer.parseInt(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick []  sticks = new Chopstick[size];
        for (int i = 0; i < sticks.length;i++){
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size;i++) {
            exec.execute(new Philosopher(sticks[i], sticks[(i+1) % size],i,ponder));
        }
        if (args.length==3&&args[2].equals("timeout")){
            TimeUnit.SECONDS.sleep(5);
        }else {
            System.out.println("Press Enter to quit");
            System.in.read();
        }
        exec.shutdownNow();

    }
}
