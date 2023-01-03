package com.kc.tools.controller;

import com.kc.tools.common.Const;
import com.kc.tools.common.ServerResponse;
import com.kc.tools.model.User;
import com.kc.tools.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 929KC
 * @date 2022/11/24 10:27
 * @description:
 */
@Controller("user")
@Slf4j
@ResponseBody
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;
    @PostMapping("login")
    public ServerResponse  login(String userId,String password ){
      ServerResponse response = userService.login(Integer.valueOf(userId), password);
        if (response.isSuccess()) {
            session.setAttribute("currentUser",response.getData());
            String token = session.getId();
            Map<String,String> map= new HashMap<>(1);
            map.put("token",token);
            response = ServerResponse.createSuccessData(map);
        }
        return response;
     }
    @GetMapping("layout")
     public ServerResponse layout(){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createSuccess();
     }
     @GetMapping("userInfo")
     public ServerResponse getUserInfo(){
        User  user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user==null) {
            return ServerResponse.createError("用户未登录,请先登录");
        }
        return ServerResponse.createSuccessData(user);
     }
}
