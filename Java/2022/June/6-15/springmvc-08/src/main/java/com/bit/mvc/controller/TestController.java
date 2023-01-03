package com.bit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-20 09:03
 */
@Controller
public class TestController {
    @RequestMapping("/testException")
    public String testException(){
        System.out.println(10/0);
        String s=null;
        s="g";
        System.out.println(s);
        return "success";
    }

}
