package com.bit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-17 09:24
 */
@Controller

public class HelloController {
    @RequestMapping("/")
    public String index (){
        return "index";
    }
    @RequestMapping("/target")
    public  String toTarget(){
        return "target";
    }
}
