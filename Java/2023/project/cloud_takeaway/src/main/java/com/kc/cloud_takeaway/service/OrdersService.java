package com.kc.cloud_takeaway.service;

import com.kc.cloud_takeaway.model.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 929KC
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2023-06-22 14:16:13
*/
public interface OrdersService extends IService<Orders> {

    void submit(Orders orders);
}
