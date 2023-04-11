package com.kc.bitblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class BitblogApplicationTests {

    @Test
    void contextLoads() {
        String password = "123456";
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(md5Password);
    }

}
