package com.kc.chatroom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.chatroom.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-07-21 19:05:38
* @Entity com.kc.chatroom.model.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByName(String username);

}




