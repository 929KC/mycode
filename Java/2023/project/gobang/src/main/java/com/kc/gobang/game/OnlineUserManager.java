package com.kc.gobang.game;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OnlineUserManager {
    private ConcurrentHashMap<Integer, WebSocketSession> gameHall = new ConcurrentHashMap<>();
    public void enterGameHall(int userId,WebSocketSession session) {
        gameHall.put(userId,session);

    }

    public void exitGameHall(int userId) {
        gameHall.remove(userId);

    }

    public  WebSocketSession getSessionFromGameHall(int userId) {
        return gameHall.get(userId);
    }
}
