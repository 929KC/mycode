package com.kc.chatroom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.chatroom.model.entity.MessageSessionUser;
import com.kc.chatroom.service.MessageSessionUserService;
import com.kc.chatroom.mapper.MessageSessionUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 929KC
* @description 针对表【message_session_user】的数据库操作Service实现
* @createDate 2023-07-22 13:46:52
*/
@Service
public class MessageSessionUserServiceImpl extends ServiceImpl<MessageSessionUserMapper, MessageSessionUser>
    implements MessageSessionUserService{

}




