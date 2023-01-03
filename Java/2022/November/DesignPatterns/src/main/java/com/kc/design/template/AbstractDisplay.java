package com.kc.design.template;

/**
 * 抽象类
 * 负责实现模板方法,负责声明在模板方法中所使用到的抽象方法
 */
public abstract class AbstractDisplay {
    public  abstract void open();
    public abstract void print();
    public abstract void close();
    public  void display(){
        open();
        for (int i = 0; i <5;i++) {
            print();
        }
        close();
    }
}
