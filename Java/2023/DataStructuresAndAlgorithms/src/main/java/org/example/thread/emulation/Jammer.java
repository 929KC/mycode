package org.example.thread.emulation;

import org.example.thread.toast.Toast;
import org.example.thread.toast.ToastQueue;

public class Jammer implements Runnable{
    private ToastQueue bufferedQueue,finishedQueue;

    public Jammer(ToastQueue bufferedQueue, ToastQueue finishedQueue) {
        this.bufferedQueue = bufferedQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = bufferedQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off");
    }
}
