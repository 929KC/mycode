package com.kc.cloud_takeaway.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.exception.BusinessException;
import com.kc.cloud_takeaway.model.dto.DishDto;
import com.kc.cloud_takeaway.model.entity.Category;
import com.kc.cloud_takeaway.model.entity.Dish;
import com.kc.cloud_takeaway.model.entity.DishFlavor;
import com.kc.cloud_takeaway.service.CategoryService;
import com.kc.cloud_takeaway.service.DishFlavorService;
import com.kc.cloud_takeaway.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public BaseResponse<String> saveDish(@RequestBody DishDto dishD) {
        if (dishD != null) {
            dishService.saveWithFlavor(dishD);
        }
        return ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @GetMapping("/page")
    public BaseResponse<Page> pageQuery(Integer page, Integer pageSize, String name) {
        log.info("page= {},pageSize= {},name= {}", page, pageSize, name);
        if (page == null || pageSize == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return dishService.dishListPageQuery(page, pageSize, name);
    }

    ///query/${id}
    @GetMapping("/query/{id}")
    public BaseResponse<DishDto> queryEmployeeById(@PathVariable("id") Long id) {
        BaseResponse<DishDto> byWithFlavor = dishService.getByWithFlavor(id);
        log.info("查询用户");
        if (byWithFlavor != null) {
            return byWithFlavor;
        }
        return ResultUtils.error(ErrorCode.NOT_QUERY_USE_ERROE);
    }
    @PutMapping("/update")
    public BaseResponse<DishDto> updateDish(@RequestBody DishDto dishDto) {
        if (dishDto==null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        dishService.updateWithFlavor(dishDto);
        return ResultUtils.success(dishDto);
    }

    @GetMapping("/list")
    public BaseResponse<List<DishDto>> getDishList(Dish dish) {
        //构造查询条件
        LambdaQueryWrapper<Dish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dish.getCategoryId() != null ,Dish::getCategoryId,dish.getCategoryId());
        //添加条件，查询状态为1（起售状态）的菜品
        queryWrapper.eq(Dish::getStatus,1);

        //添加排序条件
        queryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);

        List<Dish> list = dishService.list(queryWrapper);

        List<DishDto> dishDtoList = list.stream().map((item) -> {
            DishDto dishDto = new DishDto();

            BeanUtils.copyProperties(item,dishDto);

            Long categoryId = item.getCategoryId();//分类id
            //根据id查询分类对象
            Category category = categoryService.getById(categoryId);

            if(category != null){
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }

            //当前菜品的id
            Long dishId = item.getId();
            LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(DishFlavor::getDishId,dishId);
            //SQL:select * from dish_flavor where dish_id = ?
            List<DishFlavor> dishFlavorList = dishFlavorService.list(lambdaQueryWrapper);
            dishDto.setFlavors(dishFlavorList);
            return dishDto;
        }).collect(Collectors.toList());
        return ResultUtils.success(dishDtoList);
    }
}
