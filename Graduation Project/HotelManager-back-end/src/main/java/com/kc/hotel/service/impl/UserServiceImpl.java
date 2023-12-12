package com.kc.hotel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.hotel.mapper.UserMapper;
import com.kc.hotel.model.domain.User;
import com.kc.hotel.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}

