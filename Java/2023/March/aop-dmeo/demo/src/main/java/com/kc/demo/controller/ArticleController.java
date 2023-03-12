package com.kc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/art")
public class ArticleController {
    @GetMapping("/say")
    public  String  sayHi(String name) {
        return "Hi"+name;
    }
    @GetMapping("/hello")
    public  String  hello() {
        return "Hello World";
    }
}
