package com.bit.java.thread;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 12:57
 */

/**
 * 第一种实现线程继承
 * start()方法在执行的瞬间在内存中开辟一块供分支线程运行的栈空间,栈空间开辟后该方法的栈帧立即销毁
 * run()方法相当于主线程中的main()方法
 * run()方法在start()方法开辟栈空空间后会压栈
 *输出特点：有多有少,有先有后
 * 控制台只有一个
 */
public class ThreadText {
    public static void main(String[] args) {
        Mythread m=new Mythread();
        m.start();
        for (int i=0; i<1000; i++){
            System.out.println("main线程执行");
        }
    }
}

class Mythread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程执行");
        }
    }
}

