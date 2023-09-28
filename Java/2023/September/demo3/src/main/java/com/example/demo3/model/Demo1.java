package com.example.demo3.model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableConfigurationProperties(Demo1.class)
@ConfigurationProperties(prefix = "test")
@Data
public class Demo1 {
    private int id;
    private String name;
    private String age;
}
