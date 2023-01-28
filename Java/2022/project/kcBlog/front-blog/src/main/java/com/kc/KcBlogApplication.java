package com.kc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 929KC
 * @date 2022/11/25 22:25
 * @description:
 */
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class KcBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(KcBlogApplication.class,args);
    }
}
