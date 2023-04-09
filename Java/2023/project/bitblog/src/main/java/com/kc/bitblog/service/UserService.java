package com.kc.bitblog.service;

import com.kc.bitblog.model.domain.Userinfo;

public interface UserService {

    int register(Userinfo userInfo);

    Userinfo getUserByName(String name);
}
