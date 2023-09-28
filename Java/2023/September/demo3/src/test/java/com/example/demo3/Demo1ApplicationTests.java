package com.example.demo3;




import com.example.demo3.model.Demo1;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;


@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    private Environment environment;
    @Resource
    private Demo1 demo;

    @Value("${server.port}")
    private String port ;
    @Value("${server.address}")
    private String address ;
    @Value("${server.servlet.context-path}")
    private String contextPath ;


    @Test
    void yamlValue() {
        System.out.println(port);
        System.out.println(address);
        System.out.println(contextPath);
    }


    @Test
    void applicationValue() {
        String port = environment.getProperty("server.port");
        System.out.println(port);
        String address = environment.getProperty("server.address");
        System.out.println(address);
        String contextPath = environment.getProperty("server.servlet.context-path");
        System.out.println(contextPath);
    }

    @Test
    void pertySourceDemo() {
        System.out.println(demo);
    }
}
