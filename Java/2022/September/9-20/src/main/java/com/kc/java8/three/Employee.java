package com.kc.java8.three;

import lombok.Data;

@Data
public class Employee {
    private String name;
    private char sex;
    private double salary;
    private double bonus;
    private String punish; // 处罚信息
}
