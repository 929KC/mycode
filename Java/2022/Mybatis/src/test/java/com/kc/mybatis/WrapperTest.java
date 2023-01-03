package com.kc.mybatis;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.kc.mybatis.mapper.UserMapper;
import com.kc.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Map;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;


@SpringBootTest
public class WrapperTest {
       @Autowired
        private UserMapper userMapper;

    @Test
    public void testSelect(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.between("age",16,21);
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSort(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public  void testDelete(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.notBetween("age",16,19);
        int delete = userMapper.delete(userQueryWrapper);
        System.out.println(delete);
    }

    @Test
    public void testUpdate(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.gt("age",20).
                like("name","a").
                or().isNotNull("email");
        User user = new User();
        user.setName("薛宝钗");
        user.setAge(78);
        user.setEmail("12@qq.com");
        int update = userMapper.update(user, userQueryWrapper);
    }
    @Test
    public  void testSelect2(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.select("name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public  void testSelect3(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.inSql("id","select id from user where id <5");
        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public  void testUpdate2(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name","a").and(i->i.gt("age",6).or().isNotNull("email"));
        updateWrapper.set("name","林黛玉");
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update);
    }
    @Test
    public void testQuery(){
        String name = "a";
         Integer ageBegin = 1;
        Integer ageEnd = 20;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like(StringUtils.isBlank(name),"name",name).ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd);

        List<User> users = userMapper.selectList(userQueryWrapper);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public  void testQuery2(){
        String name = "a";
        Integer ageBegin = 1;
        Integer ageEnd = 20;
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<User>();
        userLambdaQueryWrapper.like(StringUtils.isNotBlank(name),User::getName,name).ge(ageBegin!=null,User::getAge,ageBegin)
                .le(ageEnd!=null,User::getAge,ageEnd);
        List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
@Test
    public  void testQuery3(){
    LambdaUpdateWrapper<User> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
    userLambdaUpdateWrapper.like(User ::getName,"a")
            .and(i->i.gt(User::getAge,1).or().isNotNull(User::getEmail));
    userLambdaUpdateWrapper.set(User::getName,"贾宝玉").set(User ::getEmail,"2011@qq.com");
    int update = userMapper.update(null, userLambdaUpdateWrapper);
    System.out.println(update);
}

}
