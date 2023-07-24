package com.kc.chatroom.controller;


import com.kc.chatroom.model.entity.Message;
import com.kc.chatroom.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@RestController
public class MessageController {
    @Resource
    private MessageService messageService;

    @GetMapping("/message")
    public Object getMessage(int sessionId){
        List<Message> messages = (List<Message>)messageService.getMessage(sessionId);
        Collections.reverse(messages);
        return messages;
    }
}
