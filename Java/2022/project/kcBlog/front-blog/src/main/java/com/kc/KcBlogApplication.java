package com.kc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 929KC
 * @date 2022/11/25 22:25
 * @description:
 */
@SpringBootApplication
@EnableScheduling
public class KcBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(KcBlogApplication.class,args);
    }
}
