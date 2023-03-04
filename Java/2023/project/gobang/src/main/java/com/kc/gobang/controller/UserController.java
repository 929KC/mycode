package com.kc.gobang.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/login")
    @ResponseBody
    public Object login(String username,String password) {
        return null;

    }

    @PostMapping("/register")
    @ResponseBody
    public Object register(String username,String password) {
        return null;
    }

    @GetMapping("/userInfo")
    @ResponseBody
    public Object getUserInfo() {
        return null;
    }
}
