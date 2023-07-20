package org.example.thread;

public class Blocker {
    public synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + "");
            }
        } catch (InterruptedException e) {

        }
    }
    public synchronized void prod() {
        notify();

    }
    public synchronized void prodAll() {
        notifyAll();
    }

}

