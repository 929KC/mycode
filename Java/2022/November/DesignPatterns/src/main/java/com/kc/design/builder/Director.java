package com.kc.design.builder;

/**
 * @author 929KC
 * @date 2022/11/8 8:51
 * @description:
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("从早上到晚上");
        builder.makeItems(new String[]{"早上好","下午好"});
        builder.makeString("晚上");
        builder.makeItems(new String[]{"晚上号","晚安","再见"});
        builder.close();
    }
}
