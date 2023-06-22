package com.kc.cloud_takeaway.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.model.entity.Category;

/**
* @author 929KC
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2023-06-22 13:51:12
*/
public interface CategoryService extends IService<Category> {

    void remove(Long id);

    BaseResponse<Page> categoryListPageQuery(Integer page, Integer pageSize);
}
