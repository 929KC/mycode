package com.kc.dao;

import com.kc.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    //查询所有的学生
    List<User> getAllUser();
    //插入数据
    void addUser(User user);
    //根据id删除用户
    void deleteUserById(String id);
    //更新用户信息
    void updateUser(User user);
    //分页查询
    List<User> findByPage(@Param("start") Integer start,@Param("rows") Integer rows);
    //查询总条数
    Long findTotals();

}
