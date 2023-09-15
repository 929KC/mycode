package com.example.demo4.model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "profile")
@Data
public class Profile {
    private String name;
    private String desc;
}