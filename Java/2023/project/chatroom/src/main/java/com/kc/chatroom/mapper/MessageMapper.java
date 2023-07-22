package com.kc.chatroom.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.chatroom.model.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 929KC
* @description 针对表【message】的数据库操作Mapper
* @createDate 2023-07-22 15:04:07
* @Entity com.kc.chatroom.model.entity.Message
*/
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
    String getLastMessagesBySessionId(int sessionId);
    List<Message> getMessagesBySessionId(int sessionId);

}




