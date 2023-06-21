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
import com.kc.cloud_takeaway.model.entity.Employee;
import com.kc.cloud_takeaway.service.CategoryService;
import com.kc.cloud_takeaway.service.DishFlavorService;
import com.kc.cloud_takeaway.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public BaseResponse<List<Dish>> getDishList(Dish dish) {
        if (dish==null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        LambdaQueryWrapper<Dish> lambdaQuery = new LambdaQueryWrapper<Dish>();
        lambdaQuery.eq(dish.getCategoryId()!=null,Dish::getCategoryId,dish.getCategoryId());
        lambdaQuery.eq(Dish::getStatus,1);
        lambdaQuery.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        List<Dish> list = dishService.list();
        return ResultUtils.success(list);
    }
}
