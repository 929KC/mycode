package com.kc.design.adapter.objectadapter;

/**
 * 实际交流100伏特
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }


    public void showWithParen() {
        System.out.println("("+string+")");
    }


    public void showWithAster() {
        System.out.println("*"+string+"*");
    }
}
