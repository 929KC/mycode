package com.kc.hotel.model.dto;

import com.kc.hotel.model.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnOrderDTO {

    private Order order;
    private ReturnUserDTO user;
    private ReturnRoomDTO room;


}
