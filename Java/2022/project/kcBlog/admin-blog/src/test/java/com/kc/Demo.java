package com.kc;

import com.kc.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BlogAdminApplication.class)
public class Demo {

    @Autowired
    private SecurityConfig securityConfig;
    @Test
    public void testDemo(){
        System.out.println(securityConfig);
    }
    @Test
    public void testDemo3(){
        System.out.println("Hello World");
    }



}
