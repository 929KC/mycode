package com.kc.tools.mapper;

import com.kc.tools.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author 929KC
 * @date 2022/11/24 7:46
 * @description:
 */
@Mapper
public interface UserMapper {
    int countByUserId(@Param("id") int  id);
    User selectLoginInfo(@Param("id") Integer id,@Param("password") String password );
}
