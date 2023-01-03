package com.kc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.domain.ResponseResult;
import com.kc.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-11-26 14:17:40
 */

public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}
