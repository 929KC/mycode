package com.kc.system.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo1 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("admin","123456");
        properties.setProperty("name","叶秋涵");
        properties.setProperty("pwassword","123456");
        System.out.println(properties);
        properties.store(new FileWriter("./user.properties"),"用户信息");
    }
}
