package com.kc.usercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.usercenter.model.domain.User;
import com.kc.usercenter.model.request.UserLoginRequest;
import com.kc.usercenter.model.request.UserRegisterRequest;
import com.kc.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kc.usercenter.constant.UserConstant.USER_LOGIN_STATE;

@RestController//返回值默认为json
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/register")
    public Long userRegisterRequest(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return null;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)) {
            return null;
        }
        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return null;
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        return userService.userLogin(userAccount, userPassword, request);
    }

    @GetMapping("/search")
    public List<User> searchUsers(String username,HttpServletRequest request) {
       if (!isAdmin(request)) {
           new ArrayList<>();
       }
        QueryWrapper<User> qw = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            qw.like("username",username);
        }
        List<User> userList = userService.list(qw);
        //???
        return  userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
    }

    @PostMapping("/delete")
    public boolean deleteUser(@RequestBody  long  id,HttpServletRequest request) {
        if (!isAdmin(request)) {
            return false;
        }
        if (id<=0) {
            return false;
        }
        return userService.removeById(id);
    }

    /**
     * 判断是否为管理员
     * @return
     */
    public boolean isAdmin(HttpServletRequest request){
        Object usrObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) usrObj;
        return user!=null&&user.getUserRole()==1;
    }
}
