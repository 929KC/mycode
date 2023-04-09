package com.kc.bitblog.service.impl;

import com.kc.bitblog.mapper.UserMapper;
import com.kc.bitblog.model.domain.Userinfo;
import com.kc.bitblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int register(Userinfo userInfo) {
        return userMapper.register(userInfo);
    }

    @Override
    public Userinfo getUserByName(String name) {
        return userMapper.getUserByName(name);
    }
}
