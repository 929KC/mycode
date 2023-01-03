package com.bit.dao;

import com.bit.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-13 22:02
 */

public interface UserMapper {
    User queryUserById(@Param("id") int id);
    int updateUser(User user);
}
