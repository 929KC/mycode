package com.kc.web.dao;

import com.kc.web.model.User;

/**
 * @author: 929KC
 * @date 2022/11/10 11:24
 * @description:
 * @version: 0.0.1
 **/
public interface UserMapper {
    void addUser(String username, String password,String email, String gender,String educationBackground);
}
