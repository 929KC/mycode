package com.kc.cloud_takeaway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.exception.BusinessException;
import com.kc.cloud_takeaway.model.entity.Category;
import com.kc.cloud_takeaway.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public BaseResponse<Category> addCategory(@RequestBody Category category, HttpServletRequest request) {
        log.info("新增菜品");
        categoryService.save(category);
        return ResultUtils.success(null);
    }

    @DeleteMapping("/delete")
    public BaseResponse<Category> deleteCategory(Integer id) {
        log.info("删除菜品");
        if (id != null) {
            categoryService.removeById(id);
            return ResultUtils.success(null);
        }
        return ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @GetMapping("/page")
    public BaseResponse<Page> pageQuery(Integer page, Integer pageSize) {
        log.info("page= {},pageSize= {},name= {}", page, pageSize);
        if (page == null || pageSize == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return categoryService.categoryListPageQuery(page, pageSize);
    }
}
