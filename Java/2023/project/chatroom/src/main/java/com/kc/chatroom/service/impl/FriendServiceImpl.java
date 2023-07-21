package com.kc.chatroom.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.chatroom.model.entity.Friend;
import com.kc.chatroom.service.FriendService;
import com.kc.chatroom.mapper.FriendMapper;
import org.springframework.stereotype.Service;

/**
* @author 929KC
* @description 针对表【friend】的数据库操作Service实现
* @createDate 2023-07-21 20:03:38
*/
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend>
    implements FriendService{

}




