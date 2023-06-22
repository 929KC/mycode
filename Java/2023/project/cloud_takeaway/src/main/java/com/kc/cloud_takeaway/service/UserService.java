package com.kc.cloud_takeaway.service;

import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
* @author 929KC
* @description 针对表【user(用户信息)】的数据库操作Service
* @createDate 2023-06-22 12:15:24
*/
public interface UserService extends IService<User> {

    BaseResponse<ErrorCode> sendMessage(User user, HttpSession session);

    BaseResponse<User> userLogin(Map map, HttpSession session);
}
