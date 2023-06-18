package com.kc.cloud_takeaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CloudTakeawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTakeawayApplication.class, args);
    }

}
