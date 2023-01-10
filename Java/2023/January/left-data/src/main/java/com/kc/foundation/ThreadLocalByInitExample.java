package com.kc.foundation;

public class ThreadLocalByInitExample {
    // 定义 ThreadLocal
    private static ThreadLocal<String> threadLocal = new ThreadLocal(){
        @Override
        protected String initialValue() {
            System.out.println("执行 initialValue() 方法");
            return"默认值";
        }
    };

    public static void main(String[] args) {
        // 线程执行任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 执行方法，打印线程中数据（未设置值打印）
                print(Thread.currentThread().getName());
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