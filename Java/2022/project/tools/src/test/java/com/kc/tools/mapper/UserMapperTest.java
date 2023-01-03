package com.kc.tools.mapper;

import com.kc.tools.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper ;

    @Test
    void countByUserId() {
        System.out.println(userMapper.countByUserId(123456));
    }

    @Test
    void selectLoginInf() {
         User user = userMapper.selectLoginInfo(123456, "123456");
        System.out.println(user);
    }
}