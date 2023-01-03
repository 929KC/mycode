package com.kc.mybatis;


import com.kc.mybatis.mapper.UserMapper;
import com.kc.mybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper  userMapper;
    @Test
    public  void  selectList(){
        //通过条件构造器查询表,无添加写null
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public  void insert(){
        User u = new User();
        u.setAge(19);
        u.setName("叶秋涵");
        u.setEmail("2117152669@qq.com");
        int insert = userMapper.insert(u);
        System.out.println(u.getId());
        System.out.println(insert);
    }

    @Test
    public void delete(){
        //通过id删除
        //int i = userMapper.deleteById(1558816447669940225L);
        //System.out.println(i);
        //通过Map删除
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","张三");
        map.put("age",23);
        int i = userMapper.deleteByMap(map);
        //批量删除
        List<Long> longs = Arrays.asList(1L, 2L);
        int i1 = userMapper.deleteBatchIds(longs);
        System.out.println(i1);
    }
    @Test
    public  void update(){
        User user = new User();
        user.setId(3L);
        user.setEmail("3076675259@qq.com");
        user.setName("kc");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    @Test
    public  void select(){
//        List<User> users = userMapper.selectList(null);
//        for (User user1 : users) {
//            System.out.println(user1);
 //        }
        //User user1 = userMapper.selectById(6L);
        //System.out.println(user1);
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","林黛玉");
//        map.put("age",16);
//        int i = userMapper.deleteByMap(map);
//        System.out.println(i);
//        List<Long> longs = Arrays.asList(6L, 7L);
//        List<User> users = userMapper.selectBatchIds(longs);
//        System.out.println(users);
        Map<String, Object> userById = userMapper.getUserById(6L);
        System.out.println(userById);

    }

}
