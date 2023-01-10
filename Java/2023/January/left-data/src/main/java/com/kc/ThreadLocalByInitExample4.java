package com.kc;

import java.util.function.Supplier;

public class ThreadLocalByInitExample4 {
    // 定义 ThreadLocal
    private static ThreadLocal<String> threadLocal =
            ThreadLocal.withInitial(new Supplier<String>() {
                @Override
                public String get() {
                    System.out.println("执行 withInitial() 方法");
                    return"默认值";
                }
            });
    public static void main(String[] args) {
        // 线程执行任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
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
        // 得到 ThreadLocal 中的值
        String result = threadLocal.get();
        // 打印结果
        System.out.println(threadName + " 得到值：" + result);
    }
}