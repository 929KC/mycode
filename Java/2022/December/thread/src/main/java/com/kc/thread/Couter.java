package com.kc.thread;


import java.util.Scanner;

/**
 * @author 929KC
 * @date 2022/12/16 19:09
 * @description:
 */
public class Couter {
    public  volatile int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        Couter c = new Couter();
        Thread t1 = new Thread(() -> {
            while (c.flag == 0) {

            }
            System.out.println("你是猪吗");
        });
        Thread t2 = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个整数:");
            int i = sc.nextInt();
            c.flag = i;
        });
        t1.start();
        t2.start();
    }
}
