package com.bit.thread;

public class Thread4 {
    public static void main(String[] args) {
        Thread t = new Thread(()-> System.out.println("thread"));
        t.start();
        while (true) {
            System.out.println("main");
        }
    }

}
