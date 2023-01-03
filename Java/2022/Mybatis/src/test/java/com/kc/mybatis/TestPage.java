package com.kc.mybatis;


import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.mybatis.mapper.UserMapper;
import com.kc.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestPage {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testPage(){
        Page<User> page = new Page<>(2,3);
        userMapper.selectPage(page,null);
        System.out.println(page);
    }
    @Test
    public  void testPage2(){
        Page<User> page = new Page(2,3);
        userMapper.selectPageVo(page,20);
        System.out.println(page);
    }
}
