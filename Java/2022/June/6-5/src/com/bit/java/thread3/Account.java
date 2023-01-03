package com.bit.java.thread3;

import static java.lang.Thread.sleep;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 16:42
 */

public class Account {
    private  String id;
    private  double balance;

    public Account() {

    }

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double money)  {
        //多线程共享的对象都可以,每个对象都有一把锁。共享的对象需是同一个对象。
        synchronized (this) {
            double before = this.getBalance();
            double after = before-money;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }

    }
}
