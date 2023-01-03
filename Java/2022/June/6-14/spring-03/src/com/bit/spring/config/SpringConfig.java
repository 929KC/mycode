package com.bit.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-15 15:28
 */
@Configuration//代替配置类,替代xml配置文件
@ComponentScan(basePackages = {"com.bit.spring"})//扫描文件
public class SpringConfig {
}
