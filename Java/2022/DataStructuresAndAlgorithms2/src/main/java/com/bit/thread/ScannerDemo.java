package com.bit.thread;



import java.util.Scanner;

/**
 * volatile:保证内存可见性,不保证原子性
 * 内存可见性 ：在编译器优化的背景下,一个线程对内存中的数据进行了修改,另一个线程确没法感知到
 * 编译器优化
 * 首先将数据从内存中将数据读(load)到寄存器中然后在比较(CMP)
 * CMP的速度远远大于load，所以编译器就只读一次将count = 0 读进去了,后面count修改了,也不管了
 */
public class ScannerDemo {
    static class Counter{
      public  volatile   int count = 0;
    }

    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(()->{
            while (c.count==0) {

            }
            System.out.println("t1线程结束");
        });
        t1.start();
        Thread t2 = new Thread(()->{
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个数:");
            c.count = sc.nextInt();
        });
        t2.start();
    }
}
