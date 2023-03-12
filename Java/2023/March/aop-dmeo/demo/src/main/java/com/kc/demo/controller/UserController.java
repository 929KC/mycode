package com.kc.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/say")
    public  String  sayHi(String name) {
        System.out.println("controller方法执行");
        return "Hi"+name;
    }
    @GetMapping("/hello")
    public  String  hello() {
        System.out.println("controller方法执行");
        return "Hello World";
    }
}
