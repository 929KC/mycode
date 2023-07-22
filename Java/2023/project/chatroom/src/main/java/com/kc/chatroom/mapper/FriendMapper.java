package com.kc.chatroom.mapper;

import com.kc.chatroom.common.AddFriendRequest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.chatroom.model.entity.Friend;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* @author 929KC
* @description 针对表【friend】的数据库操作Mapper
* @createDate 2023-07-21 20:03:38
* @Entity com.kc.chatroom.model.entity.Friend
*/
@Mapper
public interface FriendMapper extends BaseMapper<Friend> {
    List<Friend> findFriend(int selfUserId, String friendName);
    void addFriendRequest(int fromUserId, int toUserId, String reason);
    List<AddFriendRequest> getFriendRequest(int toUserId);
    // 删除之前的添加好友请求
    void deleteFriendRequest(int fromUserId, int toUserId);
    // 在好友表中新增⼀项
    void addFriend(int userId, int friendId);


}




