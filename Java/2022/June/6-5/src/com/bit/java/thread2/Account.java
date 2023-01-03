package com.bit.java.thread2;

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
        double before = this.getBalance();
        double after = before-money;
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setBalance(after);
        System.out.println(Thread.currentThread().getName()+"的"+this.getId()+"余额为"+getBalance());
    }
}
