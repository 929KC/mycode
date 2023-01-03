package com.kc.mvc.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 929KC
 * @date 2022/11/23 19:04
 * @description:
 */
@RestController
public class FormController {
    @PostMapping("/cacl")
    public String cacl(Integer num1,Integer num2){
        return "<h1>"+(num1+num2)+"</h1>";
    }

}
