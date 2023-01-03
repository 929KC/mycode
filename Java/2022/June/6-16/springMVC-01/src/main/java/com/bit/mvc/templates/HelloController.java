package com.bit.mvc.templates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-16 17:51
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index (){
        //返回视图名称
        return "index";
    }
}
