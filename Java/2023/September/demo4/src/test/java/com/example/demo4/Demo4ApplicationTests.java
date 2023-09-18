package com.example.demo4;

import com.example.demo4.model.Demo;
import com.example.demo4.model.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import java.util.ResourceBundle;

@SpringBootTest
class Demo4ApplicationTests {
    @Autowired
    Demo demo;
    @Value("${profile.name}")
    private String name;
    @Value("${profile.desc}")
    private String desc;
    @Autowired
    private Environment environment;
    @Autowired
    private Profile profile;
    @Test
    void contextLoads() {
        System.out.println(profile);
    }

    @Test
    void getProfileByValue() {
        System.out.println(name);
        System.out.println(desc);
    }
    @Test
    void getProfileByEnvironment() {
        System.out.println(environment.getProperty("profile.name"));
        System.out.println(environment.getProperty("profile.desc"));
    }

    @Test
    void getProfileByPropertySource() {
        System.out.println(demo);
    }


    @Test
    void getProfileByResourceBundle() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        String name = resourceBundle.getString("profile.name");
        String desc = resourceBundle.getString("profile.desc");
        System.out.println(name);
        System.out.println(desc);
    }

    @Test
    void getProfileByResourceBundle2() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        String name = resourceBundle.getString("profile.name");
        String desc = resourceBundle.getString("profile.desc");
        System.out.println(name);
        System.out.println(desc);
    }
}
