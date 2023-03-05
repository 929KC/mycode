package com.kc.gobang.controller;


import com.kc.gobang.mapper.UserMapper;
import com.kc.gobang.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @PostMapping("/login")
    @ResponseBody
    public Object login(String username, String password, HttpServletRequest request) {
        User user = userMapper.selectByUsername(username);
        if (user==null||!user.getPassword().equals(password)){
            System.out.println("登录失败");
            return new User();
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user",user);
        return user;

    }

    @PostMapping("/register")
    @ResponseBody
    public Object register(String username,String password) {
      try {
          User user = new User();
          user.setUsername(username);
          user.setPassword(password);
          userMapper.insetUser(user);
          return user;
      }catch (org.springframework.dao.DuplicateKeyException e) {//key重复抛出异常
          return new User();
      }

    }

    @GetMapping("/userInfo")
    @ResponseBody
    public Object getUserInfo(HttpServletRequest request) {
       try {
           HttpSession session = request.getSession(false);
           User user = (User) session.getAttribute("user");
           return user;
       }catch (NullPointerException e) {
           return new User();
       }
    }
}
