package org.example.thread.deadlock;


import jdk.internal.org.objectweb.asm.tree.TableSwitchInsnNode;

public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private String name;
    private int count;

    public Philosopher(Chopstick left, Chopstick right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    public void thinking() {
        System.out.println(this.name + " " + "thinking");

    }

    public void eating() {
        System.out.println(this.name + " " + "eating");
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            thinking();
            synchronized (this.left) {
                synchronized (this.right) {
                    eating();
                }
            }
        }
    }
} ///:~
