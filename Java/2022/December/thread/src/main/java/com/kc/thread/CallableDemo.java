package com.kc.thread;

import java.util.concurrent.*;

/**
 * @author 929KC
 * @date 2022/12/5 8:52
 * @description:
 */
public class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> result = es.submit(new CallableDemo());
        System.out.println(result.get());
    }
}
