package com.kc.chatroom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.chatroom.model.entity.MessageSessionUser;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【message_session_user】的数据库操作Mapper
* @createDate 2023-07-22 13:46:52
* @Entity com.kc.chatroom.model.entity.MessageSessionUser
*/
@Mapper
public interface MessageSessionUserMapper extends BaseMapper<MessageSessionUser> {

}




