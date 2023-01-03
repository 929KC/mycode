package com.bit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-20 12:29
 */
@Controller
public class ExceptionController {
    @RequestMapping("/testException")
    public String testException(){
        System.out.println(10/0);
        return "success";
    }
}
