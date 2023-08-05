package org.example.thread.bit;

public class ThreadDemo3 {
    private static class MyRunnable implements Runnable {


        @Override
        public void run() {
            System.out.println(Thread.interrupted());
           // while (!Thread.currentThread().isInterrupted()) {
            while (!Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName()
                        + ": 别管我，我忙着转账呢!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()
                            + ": 有内鬼，终止交易！");
                    System.out.println(Thread.interrupted());
                    // 注意此处的 break
                      //break;
                    //Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName()
                    + ": 啊！险些误了大事");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        System.out.println(Thread.currentThread().getName()
                + ": 让李四开始转账。");
        thread.start();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ": 老板来电话了，得赶紧通知李四对方是个骗子！");
        thread.interrupt();
    }
}
