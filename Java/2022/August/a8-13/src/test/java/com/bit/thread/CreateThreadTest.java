package com.bit.thread;

import org.junit.Test;

public class CreateThreadTest {
    @Test
    public  void createThread1(){
        MyThread m = new MyThread();
        while (true) {
            System.out.println("main");
        }
        m.run();
    }
}
