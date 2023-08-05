package org.example.thread.bit3;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了,要上课了");
            }
        },1000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了,要上课了,要迟到了");
            }
        },2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了,太阳都出来了");
            }
        },3000);

    }
}
