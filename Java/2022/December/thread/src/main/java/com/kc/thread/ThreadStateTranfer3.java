package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/16 17:37
 * @description:
 */
public class ThreadStateTranfer3 {
    private static  int num1 = 0;
    private static  int num2 = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while (!Thread.interrupted()) {
                num1++;
                System.out.println("我是黄茂云");
                Thread.yield();
            }
        });
        t.start();
        Thread t2 = new Thread(()->{
            while (!Thread.interrupted()) {
                num2++;
                System.out.println("我是叶秋涵");
            }
        });
        t2.start();
        Thread.sleep(2000);
        t.interrupt();
        t2.interrupt();
        System.out.println(num1);
        System.out.println(num2);
    }
}
