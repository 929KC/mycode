package com.kc.cloud_takeaway.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.exception.BusinessException;
import com.kc.cloud_takeaway.model.dto.SetmealDto;
import com.kc.cloud_takeaway.model.entity.Setmeal;
import com.kc.cloud_takeaway.service.SetmealService;
import jdk.internal.util.xml.impl.ReaderUTF16;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @PostMapping("/add")
    public BaseResponse<String> addCategory(@RequestBody SetmealDto setmealDto) {
        log.info("新增菜品");
        setmealService.saveWithDish(setmealDto);
        return ResultUtils.success(null);
    }

    @GetMapping("/page")
    public BaseResponse<Page> pageQuery(Integer page, Integer pageSize,String name) {
        log.info("page= {},pageSize= {},name= {}", page, pageSize);
        if (page == null || pageSize == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return setmealService.setmealListPageQuery(page, pageSize, name);
    }

    @DeleteMapping ("/delete")
    public BaseResponse deleteSetmeal(@RequestBody List<Long> ids) {
        if (ids == null ) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        setmealService.removeByIds(ids);
        return ResultUtils.success(ErrorCode.SUCCESS);
    }

    /**
     * 根据条件查询套餐数据
     * @param setmeal
     * @return
     */
    @GetMapping("/list")
    public BaseResponse<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(setmeal.getCategoryId() != null,Setmeal::getCategoryId,setmeal.getCategoryId());
        queryWrapper.eq(setmeal.getStatus() != null,Setmeal::getStatus,setmeal.getStatus());
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        List<Setmeal> list = setmealService.list(queryWrapper);
        return ResultUtils.success(list);
    }
}
