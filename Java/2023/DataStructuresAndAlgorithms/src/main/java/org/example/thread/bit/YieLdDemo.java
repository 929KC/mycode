package org.example.thread.bit;

public class YieLdDemo {
    private static int count1 = 0;
    private static int count2 = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("张三:"+count1++);
                Thread.yield();
            }
        },"t1");
        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("王五:"+count2++);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
