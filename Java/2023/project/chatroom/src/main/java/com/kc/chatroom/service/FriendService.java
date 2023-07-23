package com.kc.chatroom.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.chatroom.model.entity.Friend;

import javax.servlet.http.HttpServletRequest;

/**
* @author 929KC
* @description 针对表【friend】的数据库操作Service
* @createDate 2023-07-21 20:03:38
*/
public interface FriendService extends IService<Friend> {

    Object findFriend(String name, HttpServletRequest req);

    Object addFriend(int friendId, String reason, HttpServletRequest req);

    Object getFriendRequest(HttpServletRequest req);

    Object acceptFriend(int friendId, HttpServletRequest req);

    Object rejectFriend(int friendId, HttpServletRequest req);
}
