package com.kc.hotel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.hotel.mapper.OrderMapper;
import com.kc.hotel.service.OrderService;
import com.kc.hotel.model.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


}

