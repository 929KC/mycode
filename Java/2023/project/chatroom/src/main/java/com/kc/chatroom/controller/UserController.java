package com.kc.chatroom.controller;


import com.kc.chatroom.model.entity.User;
import com.kc.chatroom.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Resource
    UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public Object userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isAnyBlank(username, password)) {
            return null;
        }
        return userService.userLogin(username, password, request);
    }

    @ResponseBody
    @PostMapping("/register")
    public Object userRegister(String username, String password) {
        if (StringUtils.isAnyBlank(username, password)) {
            return null;
        }
        return userService.userRegister(username, password);
    }

    @GetMapping("/userInfo")
    @ResponseBody
    public Object getUserInfo(HttpServletRequest request) {
        User user = null;
        HttpSession session = request.getSession(false);
        user = (User)session.getAttribute("user");
        return user;
    }
}
