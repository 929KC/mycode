package com.bit.java.thread4;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 17:05
 */

public class AccountText {
    public static void main(String[] args) {
      Account a=new Account("hmr的卡",9000);
      Thread t1=new AccountThread(a);
      Thread t2=new AccountThread(a);
      t1.setName("t1");
      t2.setName("t2");
      t1.start();
      t2.start();
    }
}
