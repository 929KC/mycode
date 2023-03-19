package com.kc.gobang.game;

import com.kc.gobang.model.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private String roomId;
    private User user1;
    private User user2;

    public Room(String roomId) {
        this.roomId = UUID.randomUUID().toString();
    }
}
