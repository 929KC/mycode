package com.kc.cloud_takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.exception.BusinessException;
import com.kc.cloud_takeaway.model.dto.SetmealDto;
import com.kc.cloud_takeaway.model.entity.Category;
import com.kc.cloud_takeaway.model.entity.Setmeal;
import com.kc.cloud_takeaway.model.entity.SetmealDish;
import com.kc.cloud_takeaway.service.CategoryService;
import com.kc.cloud_takeaway.service.SetmealDishService;
import com.kc.cloud_takeaway.service.SetmealService;
import com.kc.cloud_takeaway.mapper.SetmealMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 929KC
 * @description 针对表【setmeal(套餐)】的数据库操作Service实现
 * @createDate 2023-06-19 20:44:21
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal>
        implements SetmealService {
    @Autowired
    private SetmealDishService setmealDishService;
    @Autowired
    private CategoryService categoryService;
    @Transactional
    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream()
                .map(item -> {
                    item.setSetmealId(String.valueOf(item.getSetmealId()));
                    return item;
                }).collect(Collectors.toList());
        setmealDishService.saveBatch(setmealDishes);
    }
    @Transactional
    @Override
    public void removeWithDish(List<Long> ids) {
            //select count(*) from setmeal where id in (1,2,3) and status = 1
            //查询套餐状态，确定是否可用删除
            LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper();
            queryWrapper.in(Setmeal::getId,ids);
            queryWrapper.eq(Setmeal::getStatus,1);

            int count = this.count(queryWrapper);
            if(count > 0){
                //如果不能删除，抛出一个业务异常
                throw new BusinessException(ErrorCode.OPERATION_ERROR);
            }

            //如果可以删除，先删除套餐表中的数据---setmeal
            this.removeByIds(ids);
            //delete from setmeal_dish where setmeal_id in (1,2,3)
            LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);
            //删除关系表中的数据----setmeal_dish
            setmealDishService.remove(lambdaQueryWrapper);

    }

    @Override
    public BaseResponse<Page> setmealListPageQuery(Integer page, Integer pageSize,String name) {
//分页构造器对象
        Page<Setmeal> pageInfo = new Page<>(page,pageSize);
        Page<SetmealDto> dtoPage = new Page<>();

        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据name进行like模糊查询
        queryWrapper.like(name != null,Setmeal::getName,name);
        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        this.page(pageInfo,queryWrapper);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo,dtoPage,"records");
        List<Setmeal> records = pageInfo.getRecords();

        List<SetmealDto> list = records.stream().map((item) -> {
            SetmealDto setmealDto = new SetmealDto();
            //对象拷贝
            BeanUtils.copyProperties(item,setmealDto);
            //分类id
            Long categoryId = item.getCategoryId();
            //根据分类id查询分类对象
            Category category = categoryService.getById(categoryId);
            if(category != null){
                //分类名称
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
            }
            return setmealDto;
        }).collect(Collectors.toList());
        dtoPage.setRecords(list);
        return ResultUtils.success(dtoPage);
    }
}




