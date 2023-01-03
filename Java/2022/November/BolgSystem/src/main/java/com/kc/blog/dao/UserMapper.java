package com.kc.blog.dao;

import com.kc.blog.model.User;

/**
 * @author 929KC
 * @date 2022/11/30 14:37
 * @description:
 */
public interface UserMapper {
    User getUserByName(String userName);

    User getUserById(int userId);
    void insetUser(User user);
}
