package com.kc.mybatis;


import com.kc.mybatis.pojo.User;
import com.kc.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@SpringBootTest
public class testService {
    @Autowired
    private UserService  userService;
    @Test
    public void testGetCount() {
        long count = userService.count();
        System.out.println("总的记录条数:"+count);
    }

    @Test
    public   void  testInsert(){
        List<User> list = new ArrayList<User>();
        for (int i= 1 ;i<=10;i++) {
            User u =new User();
            u.setAge(1+20);
            u.setName("hmr"+i);
            u.setEmail("307"+i);
            list.add(u);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);

    }
}
