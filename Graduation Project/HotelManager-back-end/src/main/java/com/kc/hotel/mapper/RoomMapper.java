package com.kc.hotel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.hotel.model.domain.Room;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


public interface RoomMapper extends BaseMapper<Room> {

    @Update("update room set state = 1 where id = #{roomId}")
    Boolean bookRoom(@Param("roomId") Integer roomId);

    @Update("update room set state = 0 where id = #{roomId}")
    Boolean finishRoom(@Param("roomId") Integer roomId);
}
