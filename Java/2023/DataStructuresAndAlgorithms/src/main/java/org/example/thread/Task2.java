package org.example.thread;

public class Task2 implements Runnable {
    public static Blocker blocker = new Blocker();

    @Override
    public void run() {

        blocker.waitingCall();
        System.out.println("waiting");
        System.out.println(blocker);
    }
}
