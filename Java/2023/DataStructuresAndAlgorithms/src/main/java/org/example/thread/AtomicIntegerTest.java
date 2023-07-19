package org.example.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable{
    private AtomicInteger ai = new AtomicInteger(0);
    public int getValue(){
        return ai.get();
    }
    private void evenIncrement(){
        ai.addAndGet(2);
    }
    @Override
    public void run() {
        evenIncrement();
    }

    public static void main(String[] args) {
       new Timer().schedule(new TimerTask() {
           @Override
           public void run() {
               System.out.println("Aborting");
               System.exit(0);
           }
       },5000);
        ExecutorService  executor = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        executor.execute(ait);
        while (true) {
            int val = ait.getValue();
            System.out.println(val);
            if (val%2!=0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
