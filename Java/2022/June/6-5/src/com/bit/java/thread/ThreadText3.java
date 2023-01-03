package com.bit.java.thread;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 13:41
 */

/**
 * 匿名内部类
 */
public class ThreadText3 {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("分支线程执行");
                }
            }
        });
        t.start();
        for(int i=0;i<1000;i++){
            System.out.println("主线程->"+i);
        }
    }
}
