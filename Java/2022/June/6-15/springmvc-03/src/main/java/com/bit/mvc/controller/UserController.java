package com.bit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * truth:talk is cheap, show me the code
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-19 10:11
 */

/**
 * 模拟用户资源的增删改查
 * 相同的请求路径不同的请求方式表示不同的操作
 */
@Controller
public class UserController {
    @RequestMapping("/rest")
    public String testRest(){
        return "test_rest";
    }
    //查询所有的用户信息
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public String getUsers(){
        System.out.println("查询所有用户信息");
        return "success";
    }
    //根据用户id查询用户信息
    @RequestMapping(value="/user/{id}",method= RequestMethod.GET)
    public String getUserById(){
        System.out.println("通过用户id查询用户信息");
        return "success";
    }
    //添加用户信息
    @RequestMapping(value="/user",method = RequestMethod.POST)
    public String postUser(String username,String password){
        System.out.println("添加用户信息："+username+","+password);
        return "success";
    }
    //修改用户信息
    @RequestMapping(value="/user",method = RequestMethod.PUT)
    public String putUser(String username,String password){
        System.out.println("修改用户信息："+username+","+password);
        return "success";
    }
}
