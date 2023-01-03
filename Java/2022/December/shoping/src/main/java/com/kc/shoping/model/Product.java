package com.kc.shoping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 929KC
 * @date 2022/12/13 17:58
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productId;
    private int categoryId;
    private String productName;
    private float price;
    private String remark;
    private String registerTime;
}
