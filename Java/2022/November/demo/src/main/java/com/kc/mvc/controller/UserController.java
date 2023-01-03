package com.kc.mvc.controller;

import com.kc.mvc.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author 929KC
 * @date 2022/11/23 15:33
 * @description:
 */
@Controller
public class UserController {
    @ResponseBody
    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }
    @ResponseBody
    @GetMapping("/getuserbyid")
    public UserInfo getUserById(Integer id) {
        //不查询数据库，这个方法目的意在接收前端一个参数返回一个数据
        //所以我们直接构造一个对应id的Userinfo对象即可
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("张三");
        userInfo.setPassword("12345678");
        return userInfo;
    }

    @ResponseBody
    @GetMapping("/login")
    public String login(String name,String password){
        return "用户名:"+name+"密码:"+password;
    }
    @ResponseBody
    @PostMapping("/object")
    public  String getObject(@RequestBody UserInfo userInfo) {
        return userInfo.toString();
    }

    @ResponseBody
    @PostMapping("/upimg")
    public boolean updateImg(Integer id,@RequestPart("img") MultipartFile file) {
        boolean result = false;
        try {
            file.transferTo(new File("E:\\img.png"));
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
