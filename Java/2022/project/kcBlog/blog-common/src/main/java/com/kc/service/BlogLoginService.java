package com.kc.service;

import com.kc.domain.ResponseResult;
import com.kc.domain.entity.User;

public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
