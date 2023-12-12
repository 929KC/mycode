package com.kc.hotel.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.hotel.model.domain.User;
import com.kc.hotel.service.CommentService;
import com.kc.hotel.service.OrderService;
import com.kc.hotel.service.UserService;
import com.kc.hotel.common.CommonResult;
import com.kc.hotel.common.StatusCode;
import com.kc.hotel.model.domain.Comment;
import com.kc.hotel.model.domain.Order;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 标识为 Spring MVC 的 RestController，并指定名称为 "adminUserController"
@RestController("adminUserController")
// 映射请求路径为 "/admin"
@RequestMapping("/admin")
public class UserController {

    // 注入 UserService、OrderService 和 CommentService 依赖
    @Resource
    private UserService userService;
    @Resource
    private OrderService orderService;
    @Resource
    private CommentService commentService;

    /**
     * 获取用户列表功能
     *
     * @return 返回用户列表的通用返回对象
     */
    @GetMapping("/listUsers")
    public CommonResult<List<User>> listUsers() {
        // 创建通用返回对象
        CommonResult<List<User>> commonResult = new CommonResult<>();

        // 查询所有用户
        List<User> userList = userService.list();

        // 设置通用返回对象的成功信息和数据
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData(userList);

        // 返回通用返回对象
        return commonResult;
    }

    /**
     * 删除用户功能
     *
     * @param userId 用户ID
     * @return 返回删除用户结果的通用返回对象
     */
    @PostMapping("/deleteUser")
    public CommonResult<String> deleteUser(@RequestParam("userId") Integer userId) {
        // 创建通用返回对象
        CommonResult<String> commonResult = new CommonResult<>();

        // 移除关联订单
        orderService.remove(new QueryWrapper<Order>().eq("user_id", userId));
        // 移除关联评论
        commentService.remove(new QueryWrapper<Comment>().eq("user_id", userId));

        // 删除用户
        boolean result = userService.removeById(userId);

        // 根据删除结果设置通用返回对象的信息和数据
        if (result) {
            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData("删除成功");
        } else {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("删除失败");
        }

        // 返回通用返回对象
        return commonResult;
    }

    /**
     * 修改用户信息功能
     *
     * @param user 用户对象
     * @return 返回修改用户信息结果的通用返回对象
     */
    @PostMapping("/updateUser")
    public CommonResult<String> updateUser(@RequestBody User user) {
        // 创建通用返回对象
        CommonResult<String> commonResult = new CommonResult<>();

        // 更新用户信息
        boolean result = userService.updateById(user);

        // 根据更新结果设置通用返回对象的信息和数据
        if (result) {
            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData("修改成功");
        } else {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("修改失败");
        }

        // 返回通用返回对象
        return commonResult;
    }

    /**
     * 根据用户ID获取用户信息功能
     *
     * @param userId 用户ID
     * @return 返回用户信息的通用返回对象
     */
    @PostMapping("/getUserById")
    public CommonResult<User> getUserById(@RequestParam("userId") Integer userId) {
        // 创建通用返回对象
        CommonResult<User> commonResult = new CommonResult<>();

        // 根据用户ID查询用户信息
        User user = userService.getById(userId);

        // 设置通用返回对象的成功信息和数据
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData(user);

        // 返回通用返回对象
        return commonResult;
    }

}