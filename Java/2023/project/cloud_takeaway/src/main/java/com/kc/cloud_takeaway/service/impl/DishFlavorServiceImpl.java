package com.kc.cloud_takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.model.entity.DishFlavor;
import com.kc.cloud_takeaway.service.DishFlavorService;
import com.kc.cloud_takeaway.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author 929KC
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2023-06-20 14:54:34
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
    implements DishFlavorService{

}




