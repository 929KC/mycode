package com.kc.hotel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CrosConfig implements WebMvcConfigurer{

    // 重写 addCorsMappings 方法来配置跨域请求
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 配置所有路径
                .allowedOriginPatterns("*") // 允许所有来源
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS") // 允许的请求方法
                .allowCredentials(true) // 允许发送 cookie
                .maxAge(3600) // 预检请求的有效期，单位秒
                .allowedHeaders("*"); // 允许的请求头
    }
}
