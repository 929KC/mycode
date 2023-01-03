package com.kc.system.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
        //读取properties文件中的键值对信息
        Properties properties = new Properties();
        System.out.println(properties);
        //加载属性文件中的键值对数据到属性对象properties中去
        properties.load(new FileReader("./user.properties"));
        System.out.println(properties);
        String name = properties.getProperty("name");
        System.out.println(name);
        String admin = properties.getProperty("admin");
        System.out.println(admin);
        String pwassword = properties.getProperty("pwassword");
        System.out.println(pwassword);
        //获取配置文件中所有的键
        Set<String> str = properties.stringPropertyNames();
        for (String s : str) {
            System.out.print(s+" ");
        }
    }
}
