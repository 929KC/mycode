package com.kc.hotel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.hotel.mapper.OrderMapper;
import com.kc.hotel.mapper.RoomMapper;
import com.kc.hotel.mapper.TypeMapper;
import com.kc.hotel.model.domain.Type;
import com.kc.hotel.service.RoomService;
import com.kc.hotel.model.domain.Order;
import com.kc.hotel.model.domain.Room;
import com.kc.hotel.model.dto.AdminReturnRoomDTO;
import com.kc.hotel.model.dto.DateSectionDTO;
import com.kc.hotel.model.dto.ReturnRoomDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private TypeMapper typeMapper;

    @Override
    public Boolean bookRoom(Integer roomId) {
        return this.getBaseMapper().bookRoom(roomId);
    }

    @Override
    public Boolean finishRoom(Integer roomId) {
        return this.getBaseMapper().finishRoom(roomId);
    }

    @Override
    public List<ReturnRoomDTO> listRooms(DateSectionDTO dateSectionDTO) {
        QueryWrapper<Room> roomQueryWrapper = new QueryWrapper<>();

        // 查询空闲房间
        List<Room> roomList = this.baseMapper.selectList(roomQueryWrapper.eq("state", 0));
        Map<Integer, Room> roomMap = roomList.stream().collect(Collectors.toMap(Room::getId, a -> a,(k1, k2)->k1));

        /**
         * lt：less than 小于
         * gt：greater than 大于
         */
        List<Order> orders = orderMapper.selectList(new QueryWrapper<Order>()
                .eq("flag", 1)
                .lt("in_time", dateSectionDTO.getInTime())
                .lt("in_time", dateSectionDTO.getLeaveTime())
                .gt("leave_time", dateSectionDTO.getInTime())
                .lt("leave_time", dateSectionDTO.getLeaveTime())
                .or()
                .eq("flag", 1)
                .gt("in_time", dateSectionDTO.getInTime())
                .lt("in_time", dateSectionDTO.getLeaveTime())
                .gt("leave_time", dateSectionDTO.getInTime())
                .gt("leave_time", dateSectionDTO.getLeaveTime())
                .or()
                .eq("flag", 1)
                .gt("in_time", dateSectionDTO.getInTime())
                .lt("in_time", dateSectionDTO.getLeaveTime())
                .gt("leave_time", dateSectionDTO.getInTime())
                .lt("leave_time", dateSectionDTO.getLeaveTime())
                .or()
                .eq("flag", 1)
                .lt("in_time", dateSectionDTO.getInTime())
                .lt("in_time", dateSectionDTO.getLeaveTime())
                .gt("leave_time", dateSectionDTO.getInTime())
                .gt("leave_time", dateSectionDTO.getLeaveTime()));

        for (Order order : orders) {
            roomMap.remove(order.getRoomId());
        }
        List<Room> rooms = new ArrayList<>(roomMap.values());

        List<ReturnRoomDTO> returnRoomDTOList = new ArrayList<>();

        if (rooms.size() != 0) {
            for (Room room : rooms) {
                ReturnRoomDTO returnRoomDTO = split(room);
                BeanUtils.copyProperties(room, returnRoomDTO);
                Type type = typeMapper.selectById(room.getType());
                returnRoomDTO.setType(type);
                returnRoomDTOList.add(returnRoomDTO);
            }
        }

        return returnRoomDTOList;
    }

    @Override
    public ReturnRoomDTO roomDetail(Integer roomId) {
        Room room = this.getBaseMapper().selectById(roomId);
        ReturnRoomDTO returnRoomDTO = split(room);
        Type type = typeMapper.selectById(room.getType());
        // System.out.println(type);
        returnRoomDTO.setType(type);
        return returnRoomDTO;
    }

    @Override
    public AdminReturnRoomDTO adminRoomDetail(Integer roomId) {
        Room room = this.getBaseMapper().selectById(roomId);
        if(room == null) {
            return null;
        }
        AdminReturnRoomDTO roomDTO = new AdminReturnRoomDTO();
        roomDTO.setRoom(room);

        Type type = typeMapper.selectById(room.getType());
        roomDTO.setType(type);

        return roomDTO;
    }

    private ReturnRoomDTO split(Room room) {
        ReturnRoomDTO returnRoomDTO = new ReturnRoomDTO();
        BeanUtils.copyProperties(room, returnRoomDTO);

        Map<String, String> introduces = new HashMap<>();
        String[] items = room.getIntroduce().split(",");
        for(String str : items) {
            String[] strs = str.split(":");
            introduces.put(strs[0], strs[1]);
        }

        returnRoomDTO.setIntroduces(introduces);

        return returnRoomDTO;
    }
}

