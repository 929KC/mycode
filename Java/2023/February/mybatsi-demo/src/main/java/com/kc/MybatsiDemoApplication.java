package com.kc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kc.mapper")
@SpringBootApplication
public class MybatsiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatsiDemoApplication.class, args);
	}

}
