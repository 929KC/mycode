package com.kc.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 929KC
 * @date 2022/11/10 11:22
 * @description: 用户
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String gender;
    private String educationBackground;

}
