package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//开启基于注解方式Servlet组件扫描支持
@SpringBootApplication
public class Chapter04Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter04Application.class, args);
    }

}
