package com.kc.tools.service.impl;

import com.kc.tools.common.ServerResponse;
import com.kc.tools.mapper.UserMapper;
import com.kc.tools.model.User;
import com.kc.tools.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 929KC
 * @date 2022/11/24 9:24
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse<User> login(Integer userId, String password) {
        int count = userMapper.countByUserId(userId);
        if (count==0) {
            return ServerResponse.createError("账户不存在");
        }
        User user = userMapper.selectLoginInfo(userId, password);
        if (user==null) {
            return ServerResponse.createError("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createSuccessData("登录成功",user);
    }
}
