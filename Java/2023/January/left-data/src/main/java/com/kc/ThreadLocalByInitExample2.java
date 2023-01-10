package com.kc;

import java.util.Date;

public class ThreadLocalByInitExample2 {
    // 定义 ThreadLocal
    private static ThreadLocal<String> threadLocal = new ThreadLocal() {
        @Override
        protected String initialValue() {
            System.out.println("执行 initialValue() 方法 " + new Date());
            return"默认值";
        }
    };
    public static void main(String[] args) {
        // 线程执行任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 得到当前线程名称
                String threadName = Thread.currentThread().getName();
                // 执行方法，打印线程中设置的值
                print(threadName);
            }
        };
        // 创建并启动线程 1
        new Thread(runnable, "MyThread-1").start();
        // 创建并启动线程 2
        new Thread(runnable, "MyThread-2").start();
    }

    /**
     * 打印线程中的 ThreadLocal 值
     * @param threadName 线程名称
     */
    private static void print(String threadName) {
        System.out.println("进入 print() 方法 " + new Date());
        try {
            // 休眠 1s
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 得到 ThreadLocal 中的值
        String result = threadLocal.get();
        // 打印结果
        System.out.println(String.format("%s 取得值：%s %s",
                threadName, result, new Date()));
    }
}