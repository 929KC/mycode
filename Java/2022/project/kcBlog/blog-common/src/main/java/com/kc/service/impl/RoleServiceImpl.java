package com.kc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.domain.entity.Role;
import com.kc.mapper.RoleMapper;
import com.kc.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2023-02-02 14:26:19
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<String> selectRoleKeyByUserId(Long id) {

        return null;
    }
}

