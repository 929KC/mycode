package com.kc.hotel.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.hotel.model.domain.Type;
import com.kc.hotel.model.domain.User;
import com.kc.hotel.service.OrderService;
import com.kc.hotel.service.RoomService;
import com.kc.hotel.service.TypeService;
import com.kc.hotel.service.UserService;
import com.kc.hotel.common.CommonResult;
import com.kc.hotel.common.StatusCode;
import com.kc.hotel.model.domain.Order;
import com.kc.hotel.model.domain.Room;
import com.kc.hotel.model.dto.BookDTO;
import com.kc.hotel.model.dto.DateSectionDTO;
import com.kc.hotel.model.dto.ReturnRoomDTO;
import com.kc.hotel.model.dto.TypeDTO;
import com.kc.hotel.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class RoomController {

    @Resource
    private RoomService roomService;
    @Resource
    private OrderService orderService;
    @Resource
    private TypeService typeService;
    @Resource
    private UserService userService;

    @PostMapping(value = "/listRoom")
    public CommonResult<List<ReturnRoomDTO>> listRoom(@RequestBody DateSectionDTO dateSectionDTO) {
        CommonResult<List<ReturnRoomDTO>> commonResult = new CommonResult<>();

        List<ReturnRoomDTO> list = roomService.listRooms(dateSectionDTO);

        commonResult.setData(list);
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        return commonResult;
    }

    @PostMapping(value = "/roomDetail")
    public CommonResult<ReturnRoomDTO> roomDetail(@RequestParam("roomId") Integer roomId) {
        CommonResult<ReturnRoomDTO> commonResult = new CommonResult<>();

        ReturnRoomDTO returnRoomDTO = roomService.roomDetail(roomId);
//        System.out.println(returnRoomDTO);
        commonResult.setData(returnRoomDTO);
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        return commonResult;
    }

    @PostMapping("/bookRoom")
    public CommonResult<String> bookRoom(@RequestBody BookDTO bookDTO) {
        CommonResult<String> commonResult = new CommonResult<>();

        User user = (User) WebUtils.getSession().getAttribute("loginUser");
        if(user == null) {
            commonResult.setData("登录信息过期");
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            return commonResult;
        }
        Room room = roomService.getById(bookDTO.getRoomId());
        if(room.getState() != 0) {
            commonResult.setData("房间已被预订");
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            return commonResult;
        }
        Type type = typeService.getById(room.getType());
        Order order = new Order();
        BeanUtils.copyProperties(bookDTO,  order);
        order.setUserId(user.getId());

        int days = (int) Math.ceil((bookDTO.getLeaveTime().getTime() - bookDTO.getInTime().getTime()) / (60 * 60 * 24 * 1000 * 1.0));
        // System.out.println(days);

        order.setRealPrice(type.getPrice() * days);
        // System.out.println(order);

        orderService.save(order);

        user.setState(1);
        userService.updateById(user);

        room.setState(1);
        roomService.updateById(room);

        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData("预订成功!");

        return commonResult;
    }

    @PostMapping("/listRoomsByTypeId")
    public CommonResult<List<ReturnRoomDTO>> listRoomsByTypeId(@RequestBody TypeDTO typeDTO) {
        CommonResult<List<ReturnRoomDTO>> commonResult = new CommonResult<>();
        QueryWrapper queryWrapper = new QueryWrapper();

        DateSectionDTO dateSectionDTO = new DateSectionDTO();
        BeanUtils.copyProperties(typeDTO, dateSectionDTO);
        List<ReturnRoomDTO> roomList = roomService.listRooms(dateSectionDTO);

        List<ReturnRoomDTO> returnRoomList = new ArrayList<>();
        if (0 != roomList.size()) {
            for (ReturnRoomDTO room : roomList) {
                if (typeDTO.getTypeId().equals(room.getType().getId())) {
                    returnRoomList.add(room);
                }
            }
        }

        commonResult.setData(returnRoomList);
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        return commonResult;
    }

}
