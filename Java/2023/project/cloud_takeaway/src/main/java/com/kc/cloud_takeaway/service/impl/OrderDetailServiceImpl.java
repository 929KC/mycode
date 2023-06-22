package com.kc.cloud_takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.model.entity.OrderDetail;
import com.kc.cloud_takeaway.service.OrderDetailService;
import com.kc.cloud_takeaway.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author 929KC
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2023-06-22 14:19:28
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




