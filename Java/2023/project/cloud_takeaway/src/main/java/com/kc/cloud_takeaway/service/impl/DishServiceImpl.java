package com.kc.cloud_takeaway.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.model.entity.Dish;
import com.kc.cloud_takeaway.service.DishService;
import com.kc.cloud_takeaway.mapper.DishMapper;
import org.springframework.stereotype.Service;

/**
* @author 929KC
* @description 针对表【dish(菜品管理)】的数据库操作Service实现
* @createDate 2023-06-19 20:44:09
*/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{

}




