package com.kc.chatroom.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.chatroom.model.entity.Friend;
import com.kc.chatroom.model.entity.User;
import com.kc.chatroom.service.FriendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class FriendController {
    @Resource
    private FriendService friendService;

    @GetMapping("/friendList")
    @ResponseBody
    public Object getFriendList(HttpServletRequest request) {
        return friendService.getFriendList(request);
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
