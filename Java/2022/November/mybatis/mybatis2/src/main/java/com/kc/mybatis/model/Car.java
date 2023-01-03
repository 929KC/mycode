package com.kc.mybatis.model;

import lombok.Data;

/**
 * @author 929KC
 * @date 2022/11/21 16:00
 * @description:
 */
@Data
public class Car {
    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private String produceTime;
    private String carType;
}
