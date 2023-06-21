package com.kc.cloud_takeaway.mapper;

import com.kc.cloud_takeaway.model.entity.SetmealDish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;



/**
* @author 929KC
* @description 针对表【setmeal_dish(套餐菜品关系)】的数据库操作Mapper
* @createDate 2023-06-21 22:03:13
* @Entity com.kc.cloud_takeaway.model.entity.SetmealDish
*/
@Mapper
public interface SetmealDishMapper extends BaseMapper<SetmealDish> {

}




