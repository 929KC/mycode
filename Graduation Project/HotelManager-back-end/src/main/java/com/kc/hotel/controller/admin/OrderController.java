package com.kc.hotel.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.hotel.model.domain.User;
import com.kc.hotel.service.OrderService;
import com.kc.hotel.service.RoomService;
import com.kc.hotel.service.UserService;
import com.kc.hotel.common.CommonResult;
import com.kc.hotel.common.StatusCode;
import com.kc.hotel.model.domain.Order;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 标识为 Spring MVC 的 RestController，并指定名称为 "adminOrderController"
@RestController("adminOrderController")
// 映射请求路径为 "/admin"
@RequestMapping("/admin")
public class OrderController {

    // 注入 OrderService、RoomService 和 UserService 依赖
    @Resource
    private OrderService orderService;
    @Resource
    private RoomService roomService;
    @Resource
    private UserService userService;

    /**
     * 获取订单列表功能
     *
     * @param flags 订单状态列表
     * @return 返回订单列表的通用返回对象
     */
    @GetMapping("/listOrders")
    public CommonResult<List<Order>> listOrders(@RequestParam("orderFlags") List<Integer> flags) {
        // 创建通用返回对象
        CommonResult<List<Order>> commonResult = new CommonResult<>();
        // 创建查询条件
        QueryWrapper queryWrapper = new QueryWrapper();
        // 设置查询条件：订单状态在传入的状态列表中
        queryWrapper.in("flag", flags);
        // 查询订单列表
        List<Order> orderList = orderService.list(queryWrapper);

        // 设置通用返回对象的成功信息和数据
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData(orderList);

        // 返回通用返回对象
        return commonResult;
    }

    /**
     * 退订订单功能
     *
     * @param orderId 订单ID
     * @return 返回退订结果的通用返回对象
     */
    @PostMapping("/unsubscribe")
    public CommonResult<String> unsubscribe(@RequestParam("orderId") Integer orderId) {
        // 创建通用返回对象
        CommonResult<String> commonResult = new CommonResult<>();

        // 根据订单ID查询订单对象
        Order order = orderService.getById(orderId);
        // 将订单状态设置为退订（flag=2）
        order.setFlag(2);
        // 更新订单信息
        boolean result = orderService.updateById(order);

        // 根据更新结果设置通用返回对象的信息和数据
        if (result) {
            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData("退订成功");
        } else {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("退订失败");
        }

        // 返回通用返回对象
        return commonResult;
    }

    /**
     * 办理入住功能
     *
     * @param orderId 订单ID
     * @return 返回办理入住结果的通用返回对象
     */
    @PostMapping("/handle")
    public CommonResult<String> handle(@RequestParam("orderId") Integer orderId) {
        // 创建通用返回对象
        CommonResult<String> commonResult = new CommonResult<>();

        // 根据订单ID查询订单对象
        Order order = orderService.getById(orderId);
        // 将订单状态设置为已办理入住（flag=1）
        order.setFlag(1);
        // 更新订单信息
        boolean result = orderService.updateById(order);

        // 根据更新结果设置通用返回对象的信息和数据
        if (result) {
            // 调用 RoomService 完成相关房间的处理
            roomService.bookRoom(order.getRoomId());
            // 查询用户对象
            User user = userService.getById(order.getUserId());
            // 计算并更新用户积分
            int jifen = (int) (user.getJifen() + order.getRealPrice());
            user.setJifen(jifen);
            userService.updateById(user);

            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData("办理入住成功");
        } else {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("办理入住失败");
        }

        // 返回通用返回对象
        return commonResult;
    }
}