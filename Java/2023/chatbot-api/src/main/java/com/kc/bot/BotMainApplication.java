package com.kc.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "com.kc.bot")
public class BotMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(BotMainApplication.class, args);
    }
}