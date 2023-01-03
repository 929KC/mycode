package com.kc.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 929KC
 * @date 2022/12/18 14:45
 * @description:
 */
public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了,你是猪吗");
            }
        }, 3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了,你是狗吗");
            }
        }, 4000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("起床了,你是猫吗");
            }
        }, 5000);
        System.out.println("开始叫他起来");
    }
}
