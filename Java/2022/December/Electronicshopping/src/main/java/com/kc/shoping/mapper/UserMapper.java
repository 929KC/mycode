package com.kc.shoping.mapper;

import com.kc.shoping.model.User;
import com.kc.shoping.vo.QueryUserVo;
import com.kc.shoping.vo.UserVo;

import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/12 9:59
 * @description:
 */
public interface UserMapper {
    int insetUser(UserVo userVo);
    List<QueryUserVo>  queryUserVo();
    User queryUser(int id);
}
