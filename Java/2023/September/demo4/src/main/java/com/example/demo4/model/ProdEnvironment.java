package com.example.demo4.model;

import com.example.demo4.config.DBConnector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdEnvironment implements DBConnector {
    @Override
    public void run() {
        System.out.println("生产环境");
    }
}
