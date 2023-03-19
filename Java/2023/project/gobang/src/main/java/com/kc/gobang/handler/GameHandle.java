package com.kc.gobang.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.gobang.game.GameReadyResponse;
import com.kc.gobang.game.OnlineUserManager;
import com.kc.gobang.game.Room;
import com.kc.gobang.game.RoomManager;
import com.kc.gobang.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class GameHandle extends TextWebSocketHandler {
    @Autowired
    private RoomManager roomManager;
    @Autowired
    private OnlineUserManager onlineUserManager;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        GameReadyResponse gameReadyResponse = new GameReadyResponse();
        User user = (User)session.getAttributes().get("user");
        if (user==null) {
            gameReadyResponse.setOk(false);
            gameReadyResponse.setReason("用户未登录");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(gameReadyResponse)));
            return;
        }
        Room room = roomManager.getRoomByUserId(user.getUserId());
        if (room==null) {
            gameReadyResponse.setOk(false);
            gameReadyResponse.setReason("用户未匹配到");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(gameReadyResponse)));
            return;
        }
        if (onlineUserManager.getSessionFromRoomHall(user.getUserId())!=null||
        onlineUserManager.getSessionFromGameHall(user.getUserId())!=null) {
            gameReadyResponse.setOk(false);
            gameReadyResponse.setReason("禁止多开");
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(gameReadyResponse)));
            return;
        }
        //设置玩家上线
        onlineUserManager.enterRoomHall(user.getUserId(),session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

    }
}
