package com.bit.java.thread4;

import static java.lang.Thread.sleep;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 16:42
 */

/**
 * synchronized
 * 第一种：同步代码块
 * 第二种：实例方法
 * 第三种：静态变量
 * 类锁：n个对象1把锁。
 * 对象锁：n个对象n把锁。
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

    /**
     * 使用synchronized修饰示例方法,一定锁的是this,且同步的是方法体中的代码块
     * 缺点：出现在实例方法上表示整个方法都需要同步,导致程序效率降低
     * 使用条件：共享的对象就是this,并且同步的代码块就是整个方法体。
     * @param money
     */
    public synchronized void withdraw(double money)  {
        //多线程共享的对象都可以,每个对象都有一把锁。共享的对象需是同一个对象。
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
