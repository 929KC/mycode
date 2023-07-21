package com.kc.chatroom.mapper;

import com.kc.chatroom.model.entity.Friend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【friend】的数据库操作Mapper
* @createDate 2023-07-21 20:03:38
* @Entity com.kc.chatroom.model.entity.Friend
*/
@Mapper
public interface FriendMapper extends BaseMapper<Friend> {

}




