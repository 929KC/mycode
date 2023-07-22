package com.kc.chatroom.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.chatroom.model.entity.MessageSession;

import javax.servlet.http.HttpServletRequest;

/**
* @author 929KC
* @description 针对表【message_session】的数据库操作Service
* @createDate 2023-07-22 10:18:00
*/
public interface MessageSessionService extends IService<MessageSession> {

    Object getMessageSessionList(HttpServletRequest request);

    Object addMessageSession(int toUserId, HttpServletRequest request);
}
