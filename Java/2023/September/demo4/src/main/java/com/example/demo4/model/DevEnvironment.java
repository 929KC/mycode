package com.example.demo4.model;

import com.example.demo4.config.DBConnector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevEnvironment implements DBConnector {
    @Override
    public void run() {
        System.out.println("开发环境");
    }
}
