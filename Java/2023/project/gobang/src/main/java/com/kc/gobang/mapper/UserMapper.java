package com.kc.gobang.mapper;

import com.kc.gobang.model.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insetUser(User user);
    User selectByUsername(String username);

}
