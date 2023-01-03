package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/16 17:21
 * @description:
 */
public class ThreadStateTransfer {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
           for (int i = 0; i < 1_0000_0000; i++) {
           }

        },"李四");
        System.out.println(thread.getName()+":"+thread.getState());
        thread.start();
        while (thread.isAlive()) {
            System.out.println(thread.getName()+":"+thread.getState());
        }
        System.out.println(thread.getName()+":"+thread.getState());
    }
}
