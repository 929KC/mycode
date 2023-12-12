package com.kc.hotel.model.dto;

import com.kc.hotel.model.domain.Type;
import com.kc.hotel.model.domain.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminReturnRoomDTO {

    private Room room;
    private Type type;


}
