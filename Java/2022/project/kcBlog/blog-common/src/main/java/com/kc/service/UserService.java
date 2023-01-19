package com.kc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.domain.ResponseResult;
import com.kc.domain.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-01-18 10:31:45
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();
}
