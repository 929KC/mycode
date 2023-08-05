package org.example.thread.bit3;

public  class MyTask implements Comparable<MyTask>{
        private Runnable command;
        private long time;

    public long getTime() {
        return time;
    }

    public MyTask(Runnable command, long time) {
            this.command = command;
            //time中存的是绝对时间,超过该时间的任务就应该被执行。
            this.time = time;
        }

        @Override
        public int compareTo(MyTask o) {
            //谁的时间小排在前面
            return (int)(time-o.time);
        }
        public void run() {
            command.run();
        }
}