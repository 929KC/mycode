package com.bit.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-19 20:03
 */
@Controller
public class TestInterceptor {
    @RequestMapping("/**/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
}
