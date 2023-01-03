package com.kc.service;

import com.kc.bean.User;

import java.util.List;

public interface UserService {
    List<User>  getAllUser();
    void addUser(User user);
    void deleteUserById(String id);
    void updateUser(User user);
     //分页查询
    List<User> findByPage( Integer start, Integer rows);
    //查询总条数
    Long findTotals();
}
