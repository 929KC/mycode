package com.kc.chatroom.handler;



import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class OnlineUserManagerHandler {
    private ConcurrentHashMap<Integer, WebSocketSession> sessions = new ConcurrentHashMap<Integer, WebSocketSession> ();

    public void onLine(int userId,WebSocketSession session){
        if (sessions.get(userId) != null) {
            return;
        }
        sessions.put(userId, session);
        System.out.println("["+userId+"] 上线");
    }
    public void offLine(int userId,WebSocketSession session){
        WebSocketSession existingSession = sessions.get(userId);
        if (existingSession!=session) {
            //当前调用离线时候的会话不是之前存储的会话.不产生实际效果
            return;
        }
        sessions.remove(userId);
        System.out.println("["+userId+"] 下线");
    }

    public WebSocketSession getSession(int userId) {
        return sessions.get(userId);
    }

}
