package com.kc.chatroom.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kc.chatroom.common.AddFriendRequest;
import com.kc.chatroom.handler.OnlineUserManagerHandler;
import com.kc.chatroom.model.entity.Friend;
import com.kc.chatroom.model.entity.User;
import com.kc.chatroom.service.FriendService;
import com.kc.chatroom.mapper.FriendMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 929KC
 * @description 针对表【friend】的数据库操作Service实现
 * @createDate 2023-07-21 20:03:38
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend>
        implements FriendService {
    @Resource
    private OnlineUserManagerHandler onlineUserManagerHandler;
    private ObjectMapper objectMapper = new ObjectMapper();
    @Resource
    FriendMapper friendMapper;

    @Override
    public Object findFriend(String name, HttpServletRequest req) {
        try {
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            return friendMapper.findFriend(user.getUserId(), name);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public Object addFriend(int friendId, String reason, HttpServletRequest req) {
        try {
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            System.out.println("[添加好友] " + user.getUserId() + ", " + friendId);
// 写⼊到数据库
            friendMapper.addFriendRequest(user.getUserId(), friendId, reason);
// 发送 websocket 响应
            WebSocketSession webSocketSession = onlineUserManagerHandler.getSession(friendId);
            if (webSocketSession != null) {
                AddFriendRequest addFriendRequest = new AddFriendRequest();
                addFriendRequest.setType("addFriendRequest");
                addFriendRequest.setFromUserId(user.getUserId());
                addFriendRequest.setFromUserName(user.getUsername());
                addFriendRequest.setReason(reason);
// 给对应的⽤⼾发送 websocket 请求, 提⽰有⽤⼾尝试加好友.
                webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(addFriendRequest)));
            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public Object getFriendRequest(HttpServletRequest req) {
        List<AddFriendRequest> addFriendRequestList = new ArrayList<>();
        try {
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            addFriendRequestList = friendMapper.getFriendRequest(user.getUserId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return addFriendRequestList;
    }

    @Override
    public Object acceptFriend(int friendId, HttpServletRequest req) {
        try {
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            // 1. 删除好友请求表的存档
            friendMapper.deleteFriendRequest(friendId, user.getUserId());
            // 2. 修改好友表
            friendMapper.addFriend(friendId, user.getUserId());
            // 3. 通过 websocket 通知对⽅刷新好友列表
            WebSocketSession webSocketSession = onlineUserManagerHandler.getSession(friendId);
            if (webSocketSession != null) {
                AddFriendRequest addFriendRequest = new AddFriendRequest();
                addFriendRequest.setType("acceptFriend");
                addFriendRequest.setFromUserId(user.getUserId());
                addFriendRequest.setFromUserName(user.getUsername());
                addFriendRequest.setReason("");
                webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(addFriendRequest)));
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    public Object rejectFriend(int friendId, HttpServletRequest req) {
        try {
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            // 删除好友请求表的存档
            friendMapper.deleteFriendRequest(friendId, user.getUserId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public Object getFriendList(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            return friendMapper.selectFriendList(user.getUserId());
        } catch (NullPointerException e) {
            e.printStackTrace();
            // 如果获取失败则返回空的好友列表
            return new ArrayList<Friend>();
        }
    }
}




