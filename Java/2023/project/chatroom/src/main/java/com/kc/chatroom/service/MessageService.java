package com.kc.chatroom.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.chatroom.model.entity.Message;

/**
* @author 929KC
* @description 针对表【message】的数据库操作Service
* @createDate 2023-07-22 20:34:01
*/
public interface MessageService extends IService<Message> {

    Object getMessage(int sessionId);
}
