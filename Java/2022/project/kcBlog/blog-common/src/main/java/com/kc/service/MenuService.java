package com.kc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.domain.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2023-02-02 14:29:31
 */
public interface MenuService extends IService<Menu> {

    List<String> selectPermsByUserId(Long id);
}
