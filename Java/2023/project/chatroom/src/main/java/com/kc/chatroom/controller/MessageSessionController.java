package com.kc.chatroom.controller;


import com.kc.chatroom.service.MessageSessionService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class MessageSessionController {
    @Resource
    private MessageSessionService messageSessionService;
    @GetMapping("/sessionList")
    @ResponseBody
    public Object getMessageSessionList(HttpServletRequest request){
        return messageSessionService.getMessageSessionList(request);
    }
    @PostMapping("/session")
    @ResponseBody
    public Object addMessageSession(int toUserId,HttpServletRequest request) {
        return messageSessionService.addMessageSession(toUserId,request);
    }


}
