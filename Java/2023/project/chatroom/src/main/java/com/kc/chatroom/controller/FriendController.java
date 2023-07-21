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
            QueryWrapper querapper = new QueryWrapper<>();
            QueryWrapper<Friend> queryWrapper = new QueryWrapper();
            queryWrapper.eq("userId", user.getUserid());
            List<Friend> list = friendService.list(queryWrapper);
            return list;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<Friend>();
        }
    }
}
