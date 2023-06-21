package com.kc.cloud_takeaway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.model.dto.SetmealDto;
import com.kc.cloud_takeaway.model.entity.Setmeal;

import java.util.List;

/**
* @author 929KC
* @description 针对表【setmeal(套餐)】的数据库操作Service
* @createDate 2023-06-19 20:44:21
*/
public interface SetmealService extends IService<Setmeal> {
    void saveWithDish(SetmealDto setmealDto);

    void removeWithDish(List<Long> ids);

    BaseResponse<Page> setmealListPageQuery(Integer page, Integer pageSize, String name);
}
