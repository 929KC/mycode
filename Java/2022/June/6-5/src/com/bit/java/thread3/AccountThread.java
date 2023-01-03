package com.bit.java.thread3;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 16:54
 */

public class AccountThread extends Thread{
    private Account aco;
    public AccountThread(Account aco){
        this.aco = aco;
    }

    @Override
    public void run() {
        double money =5000;//synchronized
        aco.withdraw(money);
        System.out.println(Thread.currentThread().getName()+"的"+this.getId()+"余额为"+aco.getBalance());
    }
}
