package com.kc.chatroom.service;

import com.kc.chatroom.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author 929KC
* @description 针对表【user】的数据库操作Service
* @createDate 2023-07-21 19:05:38
*/
public interface UserService extends IService<User> {


    Object userLogin(String username, String password, HttpServletRequest request);
    Object userRegister(String username, String password);


}
