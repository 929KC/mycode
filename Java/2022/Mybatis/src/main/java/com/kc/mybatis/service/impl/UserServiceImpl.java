package com.kc.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.mybatis.mapper.UserMapper;
import com.kc.mybatis.pojo.User;
import com.kc.mybatis.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements UserService {


}
