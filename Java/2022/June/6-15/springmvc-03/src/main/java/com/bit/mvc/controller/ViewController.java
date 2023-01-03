package com.bit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @test: 2022-06-18 21:51
 */
@Controller
public class ViewController {
    @RequestMapping("/testSuccess")
    public String success(){
        return "success";
    }

    //转发
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testSuccess";
    }
    //重定向
    @RequestMapping("/testRedirect")
     public String testRedirect(){
        return "redirect:/testSuccess";
     }

}
