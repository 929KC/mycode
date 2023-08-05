package org.example.thread.bit3;

import java.util.TimerTask;
import java.util.concurrent.ThreadPoolExecutor;

public class MyTimeDemo {
    public static void main(String[] args) {

        MyTime myTime = new MyTime();
        myTime.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了,要上课了");
            }
        }, 1000);
        myTime.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了,要上课了,要迟到了");
            }
        }, 2000);
        myTime.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了,太阳都出来了");
            }
        }, 3000);

    }
}
