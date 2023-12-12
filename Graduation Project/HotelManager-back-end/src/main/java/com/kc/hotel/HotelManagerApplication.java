package com.kc.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = "com.kc.hotel.mapper")
@EnableScheduling
public class HotelManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelManagerApplication.class, args);
    }


}
