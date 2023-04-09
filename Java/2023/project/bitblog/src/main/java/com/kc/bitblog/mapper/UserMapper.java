package com.kc.bitblog.mapper;

import com.kc.bitblog.model.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int  register(Userinfo  userinfo);
    Userinfo getUserByName(@Param("username") String username);

}
