package com.kc.gobang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.kc.gobang.mapper")
@SpringBootApplication
public class GobangApplication {

    public static void main(String[] args) {
        SpringApplication.run(GobangApplication.class, args);
    }

}
