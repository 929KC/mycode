package com.kc.system.io;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    //序列化版本号(保证反序列化的成功)
    private static final long serialVersionUID = -4985775903060349049L;
    private  String gender;
    private String name;
    private int age;
    private String address;
    private String school;
    private double weight;
}
