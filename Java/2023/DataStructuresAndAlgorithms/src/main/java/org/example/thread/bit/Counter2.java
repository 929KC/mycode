package org.example.thread.bit;

import java.util.Scanner;

public class Counter2 {
    public volatile int flags = 0;

    public static void main(String[] args) {
        Counter2 counter = new Counter2();
        Thread t1 = new Thread(() -> {
            while (counter.flags==0) {

            }
            System.out.println("循环结束");
        });
        Thread t2 = new Thread(() -> {
           Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个整数:");
            counter.flags =  scanner.nextInt();
        });
        t1.start();
        t2.start();
    }
}
