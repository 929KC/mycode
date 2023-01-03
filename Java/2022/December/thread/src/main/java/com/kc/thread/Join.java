package com.kc.thread;

/**
 * @author 929KC
 * @date 2022/12/9 20:06
 * @description:
 */
public class Join {
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("起床了,我想睡觉,在睡一会!");
                Thread.sleep(100);
                System.out.println("起床了,我不想起来,在睡一会");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        thread.join();
        System.out.println("你是猪吗?还不起来!!!");
    }
}
