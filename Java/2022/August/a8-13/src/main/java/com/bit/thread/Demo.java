package com.bit.thread;

public class Demo {
     public  static  final   long  NUM = 1_00000_00000l;

    public static void main(String[] args) throws InterruptedException {
        //serial();
        concurrent();
    }

    public  static  void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i =0 ;i<NUM;i++) {
            a++;
        }

        for ( long i = 0 ; i<NUM;i++) {
            a++;
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间:"+(end-start)+"ms");
    }

    public static  void concurrent() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t = new Thread(()->{
                long a = 0;
                for (long i = 0 ; i<NUM;i++) {
                    a++;
                }
    });
    t.start();
        Thread t2 = new Thread(()->{
            long a = 0;
            for (long i = 0 ; i<NUM;i++) {
                a++;
            }
        });
        t2.start();
        t.join();//join使得的当前的线程(指t线程所在的线程,main线程,执行该方法的线程)进入等待,
        t2.join();
   long end  = System.currentTimeMillis();
   System.out.println("执行时间"+(end-start)+"ms");
    }
}
