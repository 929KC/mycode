package org.example.kc.service;


import org.example.kc.mapper.OrderMapper;
import org.example.kc.model.Order;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
//    @Autowired
//    private RestTemplate restTemplate;


    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
//        //2.用restTemplate远程调用
//        String url = "http://userservice/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
        // 3.封装user到Order
        //order.setUser(user);
        // 4.返回
        return order;
    }

}
