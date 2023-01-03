package com.bit.java.time;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 21:04
 */

public class ThreadText5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask f = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(" FutureTask begin");
               sleep(1000);
                System.out.println(" FutureTask end");
                int a = 100;
                int b = 200;
                return a + b;
            }
        });
        Thread t = new Thread(f);
        t.start();
           Object o = f.get();
        System.out.println("线程执行结果："+o);
        System.out.println("Hello World");

    }
}
