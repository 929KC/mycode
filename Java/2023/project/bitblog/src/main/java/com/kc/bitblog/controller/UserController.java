package com.kc.bitblog.controller;


import com.kc.bitblog.common.AppVariable;
import com.kc.bitblog.common.HttpResult;
import com.kc.bitblog.model.domain.Userinfo;
import com.kc.bitblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService  userService;
    @PostMapping("/register")
    public HttpResult register(Userinfo userinfo) {
        if (userinfo == null || !StringUtils.hasLength(userinfo.getUsername()) ||
                !StringUtils.hasLength(userinfo.getPassword())) {
            return HttpResult.fail(-1,"非法参数");
        }
        return HttpResult.success(userService.register(userinfo));
    }

    @PostMapping("/login")
    public HttpResult login(String username, String password, HttpServletRequest request) {
        if ( !StringUtils.hasLength(username) ||
                !StringUtils.hasLength(password)) {
            return HttpResult.fail(-1,"非法请求");
        }
        Userinfo user = userService.getUserByName(username);
        if (user!=null&&user.getId()>0) {
            if (user.getPassword().equals(password)) {
                user.setPassword("");
                HttpSession session =request.getSession(true);
                session.setAttribute(AppVariable.USER_SESSION_KEY,user);
                return HttpResult.success(user);
            }
        }
        return HttpResult.success(0,null);
    }
}
