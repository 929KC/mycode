package com.kc.hotel.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.hotel.service.OrderService;
import com.kc.hotel.service.RoomService;
import com.kc.hotel.common.CommonResult;
import com.kc.hotel.common.StatusCode;
import com.kc.hotel.model.domain.Order;
import com.kc.hotel.model.domain.Room;
import com.kc.hotel.model.dto.AdminReturnRoomDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 标识为 Spring MVC 的 RestController，并指定名称为 "adminRoomController"
@RestController("adminRoomController")
// 映射请求路径为 "/admin"
@RequestMapping("/admin")
public class RoomController {

    // 注入 RoomService 和 OrderService 依赖
    @Resource
    private RoomService roomService;
    @Resource
    private OrderService orderService;

    /**
     * 获取房间列表功能
     *
     * @return 返回房间列表的通用返回对象
     */
    @GetMapping("/listRooms")
    public CommonResult<List<Room>> listRooms() {
        // 创建通用返回对象
        CommonResult<List<Room>> commonResult = new CommonResult<>();

        // 查询所有房间
        List<Room> roomList = roomService.list();

        // 设置通用返回对象的成功信息和数据
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData(roomList);

        // 返回通用返回对象
        return commonResult;
    }

    /**
     * 查看房间详情功能
     *
     * @param roomId 房间ID
     * @return 返回房间详情的通用返回对象
     */
    @PostMapping(value = "/roomDetail")
    public CommonResult<AdminReturnRoomDTO> roomDetail(@RequestParam("roomId") Integer roomId) {
        // 创建通用返回对象
        CommonResult<AdminReturnRoomDTO> commonResult = new CommonResult<>();

        // 调用 RoomService 获取房间详情
        AdminReturnRoomDTO returnRoomDTO = roomService.adminRoomDetail(roomId);

        // 判断房间是否存在
        if (returnRoomDTO == null) {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage("房间id不存在");
            return commonResult;
        }

        // 设置通用返回对象的数据
        commonResult.setData(returnRoomDTO);
        // 设置通用返回对象的成功信息
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        return commonResult;
    }

    /**
     * 添加房间功能
     *
     * @param room 房间对象
     * @return 返回添加房间结果的通用返回对象
     */
    @PostMapping("/addRoom")
    public CommonResult<String> addRoom(@RequestBody Room room) {
        // 创建通用返回对象
        CommonResult<String> commonResult = new CommonResult<>();
        // 根据房间号查询是否已存在相同房间号的房间
        Room roomByNumber = roomService.getOne(new QueryWrapper<Room>().eq("number", room.getNumber()));

        // 如果已存在相同房间号的房间，返回失败信息
        if (roomByNumber != null) {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("房间号已存在");
            return commonResult;
        }

        // 保存房间对象
        boolean result = roomService.save(room);

        // 根据保存结果设置通用返回对象的信息和数据
        if (result) {
            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData("添加房间成功");
        } else {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("添加房间失败");
        }

        // 返回通用返回对象
        return commonResult;
    }

    /**
     * 修改房间信息功能
     *
     * @param room 房间对象
     * @return 返回修改房间信息结果的通用返回对象
     */
    @PostMapping("/updateRoom")
    public CommonResult<String> updateRoom(@RequestBody Room room) {
        // 创建通用返回对象
        CommonResult<String> commonResult = new CommonResult<>();
        // 根据房间号查询是否已存在相同房间号的其他房间
        Room roomByNumber = roomService.getOne(new QueryWrapper<Room>().eq("number", room.getNumber()).ne("id", room.getId()));

        // 如果已存在相同房间号的其他房间，返回失败信息
        if (roomByNumber != null) {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("房间号已存在");
            return commonResult;
        }

        // 更新房间信息
        boolean result = roomService.updateById(room);

        // 根据更新结果设置通用返回对象的信息和数据
        if (result) {
            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData("修改房间信息成功");
        } else {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("修改房间信息失败");
        }

        // 返回通用返回对象
        return commonResult;
    }

    /**
     * 删除房间功能
     *
     * @param roomId 房间ID
     * @return 返回删除房间结果的通用返回对象
     */
    @PostMapping("/deleteRoom")
    public CommonResult<String> deleteRoom(@RequestParam("roomId") Integer roomId) {
        // 创建通用返回对象
        CommonResult<String> commonResult = new CommonResult<>();

        // 移除关联订单
        orderService.remove(new QueryWrapper<Order>().eq("room_id", roomId));

        // 删除房间
        boolean result = roomService.removeById(roomId);

        // 根据删除结果设置通用返回对象的信息和数据
        if (result) {
            // 根据房间ID删除相关订单
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("room_id", roomId);
            orderService.remove(queryWrapper);

            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData("删除房间成功");
        } else {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("删除房间失败");
        }

        // 返回通用返回对象
        return commonResult;
    }
}