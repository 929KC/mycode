package com.bit.boot.controller;

import com.bit.boot.bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-22 14:06
 */
@RestController
public class JsonController {
    @RequestMapping("/json1")
    public String  json() throws Exception {
        //创建一个json的对象映射器,就是一个类,它可以将对象转换成json字符串
        ObjectMapper mapper = new ObjectMapper();
        Student s=new Student("叶秋涵",19,"长沙","bit");
        String  str=mapper.writeValueAsString(s);
        return str;
    }
}
