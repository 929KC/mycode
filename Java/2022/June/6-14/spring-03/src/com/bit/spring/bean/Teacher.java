package com.bit.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-15 15:28
 */
@Component
public class Teacher {
    @Value("19")
    private  int age;
    @Value("叶秋涵")
    private String name;
    @Value("B站大学")
    private String school;
    @Value("长沙")
    private String address;

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
