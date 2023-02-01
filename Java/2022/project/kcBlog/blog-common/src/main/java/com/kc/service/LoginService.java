package com.kc.service;

import com.kc.domain.ResponseResult;
import com.kc.domain.entity.User;

public interface LoginService {

    ResponseResult login(User user);
}
