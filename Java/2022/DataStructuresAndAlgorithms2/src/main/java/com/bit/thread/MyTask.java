package com.bit.thread;

public class MyTask implements Comparable<MyTask>{
    //任务
    private Runnable runnable;
    //时间
    private long time;

    public MyTask(Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis()+time;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int) (this.time-o.time);
    }
}
