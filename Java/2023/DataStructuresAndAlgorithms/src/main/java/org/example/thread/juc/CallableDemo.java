package org.example.thread.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i=1;i<=1000;i++) {
                    sum+=i;
                }
                return sum;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        int result = futureTask.get();
        System.out.println(result);
    }
}
