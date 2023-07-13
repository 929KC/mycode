package org.example.stack;

public class MyRunnable implements Runnable {
    private String startMessage;
    private String endMessage;

    public MyRunnable(String startMessage, String endMessage) {
        this.startMessage = startMessage;
        this.endMessage = endMessage;
    }
    @Override
    public void run() {
        System.out.println(startMessage);
        for (int i = 0; i < 3; i++) {
            System.out.println("Hello World!");
            Thread.yield();
        }
        System.out.println(endMessage);
        System.out.println();

    }

    public static void main(String[] args) {
        MyRunnable m = new MyRunnable("0","1");
        m.run();

    }
}
