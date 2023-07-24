package com.kc.chatroom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.chatroom.model.entity.Friend;
import com.kc.chatroom.model.entity.MessageSession;
import com.kc.chatroom.model.entity.MessageSessionUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 929KC
* @description 针对表【message_session】的数据库操作Mapper
* @createDate 2023-07-22 10:18:00
* @Entity com.kc.chatroom.model.entity.MessageSession
*/
@Mapper
public interface MessageSessionMapper extends BaseMapper<MessageSession> {
    @Select("SELECT sessionId FROM message_session " +
            "WHERE sessionId IN (SELECT sessionId FROM message_session_user WHERE userId = #{userId}) " +
            "ORDER BY lastTime DESC")
    List<Integer> getSessionIdsByUserId(@Param("userId") Integer userId);
    @Select("SELECT userId as friendId, username as friendName " +
            "FROM user " +
            "WHERE userId IN (SELECT userId FROM message_session_user WHERE sessionId = #{sessionId})")
    List<Friend> getFriendsBySessionId(@Param("sessionId") Integer sessionId);

    int addMessageSession(MessageSession messageSession);
    void addMessageSessionUser(MessageSessionUser messageSessionUser);
}




