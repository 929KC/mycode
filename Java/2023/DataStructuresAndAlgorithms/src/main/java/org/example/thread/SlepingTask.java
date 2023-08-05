package org.example.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SlepingTask extends LiftOff {
    @Override
    public void run() {
       while (countDown-- >0){
           System.out.println(status());
           try {
               TimeUnit.MILLISECONDS.sleep(100);
               //Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
             //System.err.println("eroror: " + e.getMessage());
           }
       }
    }

    public static void main(String[] args) {
     /*   ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<3;i++) {
            executorService.execute(new SlepingTask() );
        }
        executorService.shutdownNow();*/
       for (int i=0;i<3;i++) {
           SlepingTask s = new SlepingTask();
           s.run();
       }
    }
}
