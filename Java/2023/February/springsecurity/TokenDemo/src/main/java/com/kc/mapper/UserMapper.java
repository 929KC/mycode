package com.kc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.domain.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-03 18:27:29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

