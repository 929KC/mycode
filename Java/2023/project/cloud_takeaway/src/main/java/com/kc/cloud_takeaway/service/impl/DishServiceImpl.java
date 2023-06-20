package com.kc.cloud_takeaway.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.mapper.DishFlavorMapper;
import com.kc.cloud_takeaway.model.dto.DishDto;
import com.kc.cloud_takeaway.model.entity.Category;
import com.kc.cloud_takeaway.model.entity.Dish;
import com.kc.cloud_takeaway.model.entity.DishFlavor;
import com.kc.cloud_takeaway.model.entity.Employee;
import com.kc.cloud_takeaway.service.CategoryService;
import com.kc.cloud_takeaway.service.DishFlavorService;
import com.kc.cloud_takeaway.service.DishService;
import com.kc.cloud_takeaway.mapper.DishMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 929KC
 * @description 针对表【dish(菜品管理)】的数据库操作Service实现
 * @createDate 2023-06-19 20:44:09
 */
@Service


public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
        implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public void saveWithFlavor(DishDto dishDto) {
        this.save(dishDto);
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors.stream()
                .map(item -> {
                    item.setDishId(dishDto.getId());
                    return item;
                }).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavors);
    }

    @Override
    public void updateWithFlavor(DishDto dishDto) {
        this.updateById(dishDto);
        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<DishFlavor>();
        lambdaQueryWrapper.eq(DishFlavor::getDishId, dishDto.getId());
        dishFlavorService.remove(lambdaQueryWrapper);
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream()
                .map(item -> {
                    item.setDishId(item.getId());
                    return item;
                }).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavors);
    }

    @Override
    public BaseResponse<DishDto> getByWithFlavor(Long id) {
        Dish dish = this.getById(id);
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish, dishDto);
        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<DishFlavor>();
        lambdaQueryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> list = dishFlavorService.list(lambdaQueryWrapper);
        dishDto.setFlavors(list);
        return ResultUtils.success(dishDto);
    }

    @Override
    public BaseResponse<Page> dishListPageQuery(Integer page, Integer pageSize, String name) {
        Page<Dish> pageInfo = new Page<>(page, pageSize);
        Page<DishDto> dishDtoPage = new Page<>();
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.like(name != null, Dish::getName, name);
        dishLambdaQueryWrapper.orderByDesc(Dish::getUpdateTime);
        this.page(pageInfo, dishLambdaQueryWrapper);
        BeanUtils.copyProperties(pageInfo, dishDtoPage, "records");
        List<Dish> records = pageInfo.getRecords();
        List<DishDto> list = records.stream().map(itmem ->
        {
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(itmem, dishDto);
            Long categoryId = itmem.getCategoryId();
            Category category = categoryService.getById(categoryId);
            if (category != null) {
                String name1 = category.getName();
                dishDto.setCategoryName(name1);
            }
            return dishDto;
        }).collect(Collectors.toList());
        dishDtoPage.setRecords(list);
        return ResultUtils.success(dishDtoPage);
    }
}




