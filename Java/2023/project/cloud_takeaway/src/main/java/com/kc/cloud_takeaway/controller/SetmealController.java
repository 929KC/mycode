package com.kc.cloud_takeaway.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.exception.BusinessException;
import com.kc.cloud_takeaway.model.dto.SetmealDto;
import com.kc.cloud_takeaway.service.SetmealService;
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
}
