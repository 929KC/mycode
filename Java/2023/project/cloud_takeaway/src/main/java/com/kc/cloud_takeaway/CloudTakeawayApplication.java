package com.kc.cloud_takeaway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ComponentScan("com.kc.cloud_takeaway.controller")
@MapperScan("com.kc.cloud_takeaway.mapper")
@ServletComponentScan
@SpringBootApplication
@EnableTransactionManagement
public class CloudTakeawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTakeawayApplication.class, args);
    }

}
