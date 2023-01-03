package com.bit.spring.service;

import com.bit.spring.dao.UserDao;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-14 17:22
 */

public class UserService {
  private UserDao user;

    public void setUser(UserDao user) {
        this.user = user;
    }

    public void add(){
        user.prirnt();
        System.out.println("添加一个服务");
    }
}
