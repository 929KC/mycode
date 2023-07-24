package com.kc.chatroom.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.chatroom.mapper.MessageMapper;
import com.kc.chatroom.model.entity.Message;
import com.kc.chatroom.service.MessageService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 929KC
* @description 针对表【message】的数据库操作Service实现
* @createDate 2023-07-22 20:34:01
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{
    @Resource
    private MessageMapper messageMapper;

    @Override
    public Object getMessage(int sessionId) {
        return messageMapper.getMessagesBySessionId(sessionId);
    }


}




