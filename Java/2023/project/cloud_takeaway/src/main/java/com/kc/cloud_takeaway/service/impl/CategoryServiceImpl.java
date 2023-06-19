package com.kc.cloud_takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.exception.BusinessException;
import com.kc.cloud_takeaway.model.entity.Category;
import com.kc.cloud_takeaway.model.entity.Dish;
import com.kc.cloud_takeaway.model.entity.Setmeal;
import com.kc.cloud_takeaway.service.CategoryService;
import com.kc.cloud_takeaway.mapper.CategoryMapper;
import com.kc.cloud_takeaway.service.DishService;
import com.kc.cloud_takeaway.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 929KC
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
* @createDate 2023-06-19 20:17:43
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dish = new LambdaQueryWrapper<>();
        dish.eq(Dish::getCategoryId,id);
        int count =dishService.count(dish);
        if (count > 0) {
            throw new BusinessException(ErrorCode.NOT_DELETE_DISH_ERROR);
        }
        LambdaQueryWrapper<Setmeal> setmeal = new LambdaQueryWrapper<>();
        setmeal.eq(Setmeal::getCategoryId,id);
        int count2 =setmealService.count(setmeal);
        if (count2 > 0) {
            throw new BusinessException(ErrorCode.NOT_DELETE_SETMEAL_ERROR);
        }
        super.removeById(id);
    }

    @Override
    public BaseResponse<Page> categoryListPageQuery(Integer page, Integer pageSize) {
        Page<Category> categoryPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(Category::getSort);
        this.page(categoryPage, wrapper);
        return ResultUtils.success(categoryPage);
    }
}




