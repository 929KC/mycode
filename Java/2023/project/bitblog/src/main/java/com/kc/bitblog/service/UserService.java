package com.kc.bitblog.service;

import com.kc.bitblog.model.domain.Userinfo;
import io.swagger.models.auth.In;

public interface UserService {

    int register(Userinfo userInfo);

    Userinfo getUserByName(String name);
    Userinfo  getUserById(Integer id);
}
