package com.kc.design.singleton;

/**
 * @author 929KC
 * @date 2022/11/6 22:39
 * @description: 单例模式
 */
public class Singleton {
    private  static Singleton  singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }

    public Singleton() {
        System.out.println("生成了一个单例");
    }
}
