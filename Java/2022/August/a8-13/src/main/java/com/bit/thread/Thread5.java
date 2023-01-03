package com.bit.thread;

public class Thread5 {
    public static void main(String[] args) {
        Thread t =new Thread(){
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        t.start();
        System.out.println("2");
    }
}
