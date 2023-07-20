package org.example.thread.emulation;

import org.example.thread.toast.Toast;
import org.example.thread.toast.ToastQueue;

public class Butter implements Runnable {
    private ToastQueue dryQueue,butteredQueue;

    public Butter(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = dryQueue.take();
                t.buffer();
                System.out.println(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer off");
    }
}
