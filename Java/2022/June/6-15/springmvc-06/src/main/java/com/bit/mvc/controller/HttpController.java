package com.bit.mvc.controller;

import com.bit.mvc.bean.Student;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-19 16:11
 */
@Controller
public class HttpController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody:"+requestBody);
        return "success";
    }
    @RequestMapping("/testRequestEntity")
    public String testRequestBody(RequestEntity<String> requesstEntity) {
        //RequestEntity表示整个报文信息
        System.out.println("请求头:"+requesstEntity.getHeaders());
        System.out.println("请求体"+requesstEntity.getBody());
        return "success";
    }
    @RequestMapping("/testResponse")
    public void testRequestBody(HttpServletResponse response) throws IOException {
        //RequestEntity表示整个报文信息
      response.getWriter().print("Hello World");
    }
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponse(){
        String name="叶子秋";
        return name;
    }
    @RequestMapping("/testResponseStudent")
    @ResponseBody
    public Student testResponse2(){
        return new Student("叶秋涵","女","B站","郴州");
    }
    @RequestMapping("/testAjax")
    @ResponseBody
    public String testAjax(String username, String password){
        System.out.println("username:"+username+",password:"+password);
        return "hello,ajax";
    }

}
