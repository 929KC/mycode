package com.bit.thread;

public class Thread3 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
            while (true) {
                System.out.println("main");
            }
            }
        };
        t.start();
        while (true){
            System.out.println("thread");
        }

    }
}
