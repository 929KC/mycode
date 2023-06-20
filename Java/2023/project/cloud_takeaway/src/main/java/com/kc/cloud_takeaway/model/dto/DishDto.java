package com.kc.cloud_takeaway.model.dto;

;
import com.kc.cloud_takeaway.model.entity.Dish;
import com.kc.cloud_takeaway.model.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors = new ArrayList<>();
    private String categoryName;
    private Integer copies;
}
