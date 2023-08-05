package org.example.thread.bit3;



import javafx.concurrent.Worker;

import java.util.concurrent.PriorityBlockingQueue;

public class MyTime {
    /**
     * 锁对象
     */
    private final Object lock = new Object();
    /**
     * 每次执行任务,优先执行时间在前的任务,也就是每次都得从优先级对列中取出时间最小的任务
     */
    private static final PriorityBlockingQueue<MyTask>  queue = new PriorityBlockingQueue<>();

    /**
     * 安排任务
     * @param runnable
     * @param after
     */
    public void schedule(Runnable runnable,long after) {
        MyTask myTask = new MyTask(runnable,after);
        queue.offer(myTask);
        synchronized (lock) {
             //每次当新任务加载到阻塞队列时，需要中途唤醒线程，因为新进来的任务可能是最早需要执行的
            lock.notify();
        }
    }

    /**
     * 启动扫描线程
     */
    public MyTime(){
        Worker worker = new Worker();
        worker.start();
    }

    /**
     *  扫描线程一直不停的扫描队首元素, 看看是否能执行这个任务.
     */
    private  class Worker extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    MyTask task = queue.take();
                    long currentTime = System.currentTimeMillis();
                    if (task.getTime() > currentTime) {
                      synchronized (lock) {
                          //任务被执行的时间还没有到,把任务塞回队列
                          queue.put(task);
                          //设置指定等待时间 wait
                          lock.wait(task.getTime()-currentTime);
                      }
                    }else {
                        //时间到了,可以执行任务
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

}
