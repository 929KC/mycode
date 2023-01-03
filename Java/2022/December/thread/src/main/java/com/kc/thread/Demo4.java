package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/5 8:38
 * @description:
 */
public class Demo4 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello Wolrd"));
        thread.start();
        new Thread(() -> System.out.println("hello Wolrd")).start();
        System.out.println(thread);
        System.out.println(thread.currentThread());
    }
}
