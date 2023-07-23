package com.kc.chatroom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.chatroom.common.AddFriendRequest;
import com.kc.chatroom.model.entity.Friend;
import com.kc.chatroom.model.entity.User;
import com.kc.chatroom.service.FriendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FriendController {
    @Resource
    private FriendService friendService;

    @GetMapping("/friendList")
    @ResponseBody
    public Object getFriendList(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            QueryWrapper<Friend> queryWrapper = new QueryWrapper();
            queryWrapper.eq("userId", user.getUserId());
            List<Friend> list = friendService.list(queryWrapper);
            return list;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<Friend>();
        }
    }

    @GetMapping("/findFriend")
    @ResponseBody
    public Object findFriend(String name, HttpServletRequest req) {
        return friendService.findFriend(name, req);
    }

    @GetMapping("/addFriend")
    @ResponseBody
    public Object addFriend(int friendId, String reason, HttpServletRequest req) {
        return friendService.addFriend(friendId, reason, req);
    }

    @GetMapping("/getFriendRequest")
    @ResponseBody
    public Object getFriendRequest(HttpServletRequest req) {
        return friendService.getFriendRequest(req);
    }

    @GetMapping("/acceptFriend")
    @ResponseBody
    public Object acceptFriend(int friendId, HttpServletRequest req) {
        return friendService.acceptFriend(friendId, req);
    }

    @GetMapping("/rejectFriend")
    @ResponseBody
    public Object rejectFriend(int friendId, HttpServletRequest req) {
        return friendService.rejectFriend(friendId, req);
    }
}
