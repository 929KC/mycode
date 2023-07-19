package org.example.thread.emulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++) {
            executorService.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        executorService.shutdown();
        //等待每个任务结束，如果所有的任务在超时时间达到之前全部结束，
        // 则返回true，否则返回false，表示不是所有的任务都已经结束了。
        if (!executorService.awaitTermination(250,TimeUnit.MILLISECONDS)) {
            System.out.println("Some tasks were not teminated");
        }
        System.out.println("Total:"+Entrance.getTotalCount());
        System.out.println("Sum of Entrances:"+Entrance.sumEntrances());
    }
}
