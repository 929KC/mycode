package com.kc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-02 14:23:06
 */

@Mapper
public interface RoleMapper extends BaseMapper<Role> {


    /**
     * @param id
     * @return
     */
    List<String> selectRoleKeyUserId(Long id);
}

