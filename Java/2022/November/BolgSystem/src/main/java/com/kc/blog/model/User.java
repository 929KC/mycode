package com.kc.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 929KC
 * @date 2022/11/13 20:32
 * @description: 用户实体类
 */
@Data
@AllArgsConstructor
public class User {
    private int userId = 0;
    private String username = "";
    private String password = "";

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
