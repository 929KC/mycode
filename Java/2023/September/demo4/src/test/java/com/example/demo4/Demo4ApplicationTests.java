package com.example.demo4;

import com.example.demo4.model.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo4ApplicationTests {
    @Autowired
    private Profile profile;
    @Test
    void contextLoads() {
        System.out.println(profile);
    }

}
