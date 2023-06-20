package com.kc.cloud_takeaway.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.model.dto.DishDto;
import com.kc.cloud_takeaway.model.entity.Dish;
import com.kc.cloud_takeaway.model.entity.Employee;

/**
* @author 929KC
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2023-06-19 20:44:09
*/
public interface DishService extends IService<Dish> {
    void saveWithFlavor(DishDto dishDto);
    void updateWithFlavor(DishDto dishDto);
    BaseResponse<DishDto> getByWithFlavor(Long id);
    BaseResponse<Page> dishListPageQuery(Integer page, Integer pageSize, String name);
}
