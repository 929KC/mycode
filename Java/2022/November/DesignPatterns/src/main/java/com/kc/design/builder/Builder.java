package com.kc.design.builder;

/**
 * @author 929KC
 * @date 2022/11/8 8:50
 * @description: 定义决定文档结构的方法的抽象类
 */
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String [] items);
    public  abstract void close();
}
