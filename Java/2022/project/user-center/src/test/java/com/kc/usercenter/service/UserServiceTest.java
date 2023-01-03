package com.kc.usercenter.service;
import com.kc.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("黄茂云");
        user.setUserAccount("huang");
        user.setAvatarUrl("https://www.code-nav.cn/rd/?rid=617ef50c621f22e9094a6c6916bd9496");
        user.setGender(0);
        user.setUserPassword("");
        user.setPhone("1234");
        user.setEmail("397235jsdf");
        user.setUserStatus(0);
        user.setIsDelete(0);
        boolean result = userService.save(user);
        Assertions.assertEquals(true,result);
    }

    @Test
    void userRegister() {
        String userAccount = "yupi";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "yu";
         result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "yupi";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "yu pi";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "dogYupi";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        userAccount = "yupi";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
    }

    @Test
     void testChar(){
        String str = "huang";
        String regEx = "\\pP|\\pS|\\s+";
        Matcher matcher = Pattern.compile(regEx).matcher(str);
        if (matcher.find()) {
            System.out.println("找到特殊字符");
        }else {
            System.out.println("没有找到");
        }
    }
}
