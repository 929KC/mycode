package com.kc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadLocalByDateFormat {
    // 创建 ThreadLocal 并设置默认值
    private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));

    public static void main(String[] args) {
        // 创建线程池执行任务
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));
        // 执行任务
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            // 执行任务
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 得到时间对象
                    Date date = new Date(finalI * 1000);
                    // 执行时间格式化
                    formatAndPrint(date);
                }
            });
        }
        // 线程池执行完任务之后关闭
        threadPool.shutdown();
        // 线程池执行完任务之后关闭
        threadPool.shutdown();
    }
    /**
     * 格式化并打印时间
     * @param date 时间对象
     */
    private static void formatAndPrint(Date date) {
        // 执行格式化
        String result = dateFormatThreadLocal.get().format(date);
        // 打印最终结果
        System.out.println("时间：" + result);
    }
}