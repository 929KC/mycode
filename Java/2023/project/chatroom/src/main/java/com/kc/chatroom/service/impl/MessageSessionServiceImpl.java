package com.kc.chatroom.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.chatroom.mapper.MessageMapper;
import com.kc.chatroom.model.entity.Friend;
import com.kc.chatroom.model.entity.MessageSession;
import com.kc.chatroom.model.entity.MessageSessionUser;
import com.kc.chatroom.model.entity.User;
import com.kc.chatroom.service.MessageSessionService;
import com.kc.chatroom.mapper.MessageSessionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 929KC
 * @description 针对表【message_session】的数据库操作Service实现
 * @createDate 2023-07-22 10:18:00
 */
@Service
@Slf4j
public class MessageSessionServiceImpl extends ServiceImpl<MessageSessionMapper, MessageSession>
        implements MessageSessionService {
    @Resource
    private MessageSessionMapper messageSessionMapper;
    @Resource
    private MessageMapper messageMapper;
    @Override
    public Object getMessageSessionList(HttpServletRequest request) {
        List<MessageSession> list = new ArrayList<MessageSession>();
        // 1. 获取到当前⽤⼾ id
        User user = (User) request.getSession(false).getAttribute("user");
        Integer userId = user.getUserId();
        // 2. 根据⽤⼾ id 查询到该 id 名下的会话 id.
        List<Integer> sessionIds = messageSessionMapper.getSessionIdsByUserId(userId);
        for (Integer sessionId : sessionIds) {
            MessageSession messageSession = new MessageSession();
            // 3. 根据会话 id 找到对应的好友列表
            List<Friend> friends = messageSessionMapper.getFriendsBySessionId(sessionId);
            messageSession.setFriends(friends);
            // 4. TODO 根据会话 id 找到历史消息记录, 需要设计好 消息表
            String lastMessage = messageMapper.getLastMessagesBySessionId(sessionId);
            if (lastMessage == null) {
                messageSession.setLastMessage("");
            } else {
                messageSession.setLastMessage(lastMessage);
            }
            list.add(messageSession);
        }
        return list;
    }

    @Override
    @Transactional
    public Object addMessageSession(int toUserId, HttpServletRequest request) {
        Map<String,Integer> resp = new HashMap<String,Integer>();
        HttpSession session = request.getSession(false);
        User user =(User) session.getAttribute("user");
        MessageSession messageSession = new MessageSession();
         messageSessionMapper.addMessageSession(messageSession);
        log.info("生成新会话:"+messageSession.getSessionId());
        MessageSessionUser messageUser1 = new MessageSessionUser();
        messageUser1.setSessionId(messageSession.getSessionId());
        messageUser1.setUserId(user.getUserId());
        messageSessionMapper.addMessageSessionUser(messageUser1);

        MessageSessionUser messageUser2 = new MessageSessionUser();
        messageUser2.setSessionId(messageSession.getSessionId());
        messageUser2.setUserId(toUserId);
        messageSessionMapper.addMessageSessionUser(messageUser2);
        resp.put("sessionId",messageSession.getSessionId());
        return resp;
    }
}




