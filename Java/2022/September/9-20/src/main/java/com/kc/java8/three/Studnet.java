package com.kc.java8.three;

import lombok.Data;

@Data
public class Studnet {
    private String name;



    public Studnet(String s) {
        this.name =s;
    }
}
