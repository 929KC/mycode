package com.kc.hotel.component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.hotel.service.RoomService;
import com.kc.hotel.model.domain.Order;
import com.kc.hotel.service.OrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


// 将类标记为 Spring 的组件，使其能够被 Spring 容器管理
@Component
public class TimedTask {

    // 注入 OrderService 和 RoomService 依赖
    @Resource
    private OrderService orderService;
    @Resource
    private RoomService roomService;

    // 使用 @Scheduled 注解标识这是一个定时任务，定义了任务的执行规则
    @Scheduled(cron = "*/10 * * * * ?")
    public void scheduled() {
        // 创建查询条件
        QueryWrapper queryWrapper = new QueryWrapper();
        Date nowDate = new Date();
        // 查询条件：离开时间小于当前时间，标记为 1（可能是未完成的订单）
        queryWrapper.lt("leave_time", nowDate);
        queryWrapper.eq("flag", 1);

        try {
            // 查询满足条件的订单列表
            List<Order> orderList = orderService.list(queryWrapper);

            // 如果存在满足条件的订单
            if (!orderList.isEmpty()) {
                // 遍历订单列表，处理每个订单
                for (Order order : orderList) {
                    // 将订单标记为已完成（flag=3）
                    order.setFlag(3);
                    // 调用 RoomService 完成相关房间的处理
                    roomService.finishRoom(order.getRoomId());
                }
                // 批量更新订单列表
                orderService.updateBatchById(orderList);
            }

        } catch (Exception e) {
            // 异常处理，可以根据实际情况添加日志记录等
        }
    }
}