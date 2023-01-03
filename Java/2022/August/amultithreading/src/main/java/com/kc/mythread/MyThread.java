package com.kc.mythread;

public class MyThread  extends Thread{
    @Override
    public void run() {
        super.run();
       for (int i = 0; i <50000;i++){
           if (this.interrupted()){
               System.out.println("线程已是停止状态,我要退出了");
               break;
           }
           System.out.println("i="+(i+1));
       }
    }
}
