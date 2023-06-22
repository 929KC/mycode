package com.kc.cloud_takeaway.controller;


import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.model.entity.User;
import com.kc.cloud_takeaway.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/sendMsg")
    public BaseResponse<ErrorCode> sendMessage(@RequestBody User user, HttpSession session) {
        if (user==null) {
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        return userService.sendMessage(user, session);
    }
    @PostMapping("/login")
    public BaseResponse<User> login(@RequestBody Map map, HttpSession session) {


        return userService.userLogin(map, session);
    }
}
