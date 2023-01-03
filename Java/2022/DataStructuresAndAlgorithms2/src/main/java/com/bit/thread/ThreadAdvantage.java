package com.bit.thread;

public class ThreadAdvantage {
    private  final  static long   count = 1000_0000_0000L;

    public static void main(String[] args) throws InterruptedException {
        //并发执行
        concurrency();
        //使用出串行
        serial();
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        long a = 0;
        for (long i=0;i<count;i++) {
            a++;
        }
        a = 0;
        for (long i = 0;i<count;i++) {
            a++;
        }
        long end = System.currentTimeMillis();
        System.out.println("串行执行花费:"+(end-start)+"ms");
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(){
            @Override
            public void run() {
               long  a =0;
               for (long i = 0;i<count;i++) {
                   a++;
               }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                long a = 0;
                for (long  i = 0;i<count;i++) {
                    a++;
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();//join()阻塞等待,在main中调用该方法，main 线程等待t1线程执行完后继续执行
        t2.join();
       long end =  System.currentTimeMillis();
        System.out.println("并发执行花费了:"+(end-start)+"ms");
    }
}
