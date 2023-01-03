package com.kc.java8.two;

import lombok.Data;

@Data
public class Apple {
    private String color;
    private  int  weight;


    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;

    }

    public Apple() {
    }
}
