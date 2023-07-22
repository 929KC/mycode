package com.kc.chatroom.controller;


import com.kc.chatroom.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageController {
    @Resource
    private MessageService messageService;

    @GetMapping("/message")
    public Object getMessage(int sessionId){
        return messageService.getMessage(sessionId);
    }
}
