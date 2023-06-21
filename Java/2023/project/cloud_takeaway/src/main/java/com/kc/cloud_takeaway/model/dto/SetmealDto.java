package com.kc.cloud_takeaway.model.dto;


import com.kc.cloud_takeaway.model.entity.Setmeal;
import com.kc.cloud_takeaway.model.entity.SetmealDish;
import lombok.Data;

import java.util.List;


@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
