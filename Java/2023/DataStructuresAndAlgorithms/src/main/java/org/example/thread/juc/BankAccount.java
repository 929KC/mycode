package org.example.thread.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private AtomicInteger balance;

    public BankAccount(int initialBalance) {
        this.balance = new AtomicInteger(initialBalance);
    }

    public boolean withdraw(int amount) throws InterruptedException {
        int currentBalance = balance.get();
        if (currentBalance >= amount) {
            //让出CPU
            Thread.yield();
            return balance.compareAndSet(currentBalance, currentBalance - amount);
        }
        return false;
    }

    public int getBalance() {
        return balance.get();
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);

        Runnable withdrawTask = () -> {
            boolean success = false;
            try {
                success = account.withdraw(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (success) {
                System.out.println(Thread.currentThread().getName() + " withdrew 50 successfully.");
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to withdraw 50. Insufficient funds.");
            }
        };
        Thread thread1 = new Thread(withdrawTask, "Thread 1");
        Thread thread2 = new Thread(withdrawTask, "Thread 2");

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final balance: " + account.getBalance());
    }
}
