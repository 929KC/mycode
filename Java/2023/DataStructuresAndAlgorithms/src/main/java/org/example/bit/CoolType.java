package org.example.bit;


import java.lang.reflect.Constructor;


public enum CoolType {
    RED("红色", 1),
    BLACK("黑色", 2),
    GREEN("绿色", 3);

    private String color;
    private int key;

    CoolType(String color, int key) {
        this.color = color;
        this.key = key;
    }

    public String getColor() {
        return color;
    }

    public int getKey() {
        return key;
    }

    public static void main(String[] args) {
        for (CoolType c: CoolType.values()) {
            System.out.println("color:"+c.color+"key:"+c.key);
        }
    }
}
