package com.kc.hotel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.hotel.model.domain.Room;
import com.kc.hotel.model.dto.AdminReturnRoomDTO;
import com.kc.hotel.model.dto.DateSectionDTO;
import com.kc.hotel.model.dto.ReturnRoomDTO;

import java.util.List;


public interface RoomService extends IService<Room> {

    Boolean bookRoom(Integer roomId);

    Boolean finishRoom(Integer roomId);

    List<ReturnRoomDTO> listRooms(DateSectionDTO dateSectionDTO);

    ReturnRoomDTO roomDetail(Integer roomId);

    AdminReturnRoomDTO adminRoomDetail(Integer roomId);
}
