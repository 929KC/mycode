package com.kc.chatroom.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.chatroom.model.entity.User;
import com.kc.chatroom.service.UserService;
import com.kc.chatroom.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 929KC
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-07-21 19:05:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public Object userLogin(String username, String password, HttpServletRequest request) {
        if (StringUtils.isAnyBlank(username, password)) {
            return null;
        }
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("username", username);
        User user = this.baseMapper.selectOne(query);
        if (user == null || !user.getPassword().equals(password)) {
            return new User();
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        return user;
    }

    @Override
    public Object userRegister(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean saveResult = this.save(user);
        if (!saveResult) {
            System.out.println("注册失败，数据库错误");
        }
        return user;
    }
}




