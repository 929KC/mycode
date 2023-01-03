package com.kc.tools.service;

import com.kc.tools.common.ServerResponse;
import com.kc.tools.model.User;
import org.springframework.stereotype.Service;

/**
 * @author 929KC
 * @date 2022/11/24 7:56
 * @description:
 */

public interface UserService {
    ServerResponse<User> login(Integer userId, String password);
}
