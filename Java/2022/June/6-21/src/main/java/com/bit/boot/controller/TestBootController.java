package com.bit.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-21 09:43
 */
@RestController
public class TestBootController {
    @RequestMapping("/Hello")
    public String testHello(){
        return "HelloWorld,Boot,我是黄茂荣";
    }
}
