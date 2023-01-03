package com.bit.dao;

import com.bit.bean.User;

import java.util.List;

public interface UserDao {
    //获取所有用户
    List<User> getUserList();
    //根据用户id查询用户
    User getUserById(int id);
    //添加用户
   int addUser(User user);
   //修改用户
   int  updateUser(User user);
    //删除用户
   int  deleteUser(int id);
}
