package com.example.demodocker;

import com.example.demodocker.model.User;
import org.junit.jupiter.api.Test;

public class Demo {
    @Test
    void builderTest() {
        User user = User.builder().username("叶秋涵").age(17).build();
        System.out.println(user);
        System.out.println("ds");
        System.out.println("ds"); System.out.println("ds");
        System.out.println("ds");


    }
}
