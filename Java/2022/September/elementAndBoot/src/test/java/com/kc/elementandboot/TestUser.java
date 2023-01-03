package com.kc.elementandboot;

import com.kc.bean.User;
import com.kc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestUser {
    @Autowired
    private UserService userService;
    @Test
    public void testUserDao(){
        List<User> allUser = userService.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
    }
    @Test
    public void testAddUser(){
        User u =new User();
        u.setName("薛宝钗");
        u.setDir(new Date());
        u.setSex("女");
        u.setAddress("徐州");
        userService.addUser(u);
    }
    @Test
    public  void testDeleteUserVById(){
        userService.deleteUserById("10");
    }
}
