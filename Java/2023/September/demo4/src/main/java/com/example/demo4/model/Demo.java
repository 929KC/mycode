package com.example.demo4.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration//注入spring容器
@EnableConfigurationProperties(Demo.class)//开启对配置类属性输入的功能
@ConfigurationProperties(prefix = "profile")//指定配置文件属性注入前缀
@PropertySource("classpath:application.properties")//指定配置文件路径和名称
@Data
public class Demo {
    private String name;
    private String desc;
}
