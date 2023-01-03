package com.bit.java.thread;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 13:19
 */

/**
 * 接口
 */
public class ThreadText2 {
    public static void main(String[] args) {
        //创建一个可运行的对象
        Mythread m=new Mythread();
        //将运行的对象封装成线程
        Thread t=new Thread(m);
        //启动线程
        t.start();
        for(int i=0;i<1000;i++){
            System.out.println("主线程->"+i);
        }

    }
}

//该类是一个可运行的类还不是一个线程类
class Mythead implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <1000;i++){
            System.out.println("分支线程->"+i);
        }
    }
}

