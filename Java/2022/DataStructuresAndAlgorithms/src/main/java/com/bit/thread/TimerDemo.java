package com.bit.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer内部需要一组线程来执行注册的任务
 * 而这里的线程是前台线程,会影响进程退出
 */
public class TimerDemo {
    public static void main(String[] args) {
        Timer t = new Timer();
       t.schedule(new TimerTask() {
           @Override
           public void run() {
               System.out.println("你是猪吗?");
           }
       },1000);
       t.schedule(new TimerTask() {
           @Override
           public void run() {
               System.out.println("我是猪");
           }
       },2000);

    }
}
