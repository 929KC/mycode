package com.kc.cloud_takeaway.mapper;

import com.kc.cloud_takeaway.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【user(用户信息)】的数据库操作Mapper
* @createDate 2023-06-22 12:15:24
* @Entity com.kc.cloud_takeaway.model.entity.User
*/

@Mapper
public interface UserMapper extends BaseMapper<User> {

}




