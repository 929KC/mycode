package com.kc.gobang.game;


import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class RoomManager {
    private ConcurrentHashMap<String, Room> rooms = new
            ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, String> userIdToRoomId = new
            ConcurrentHashMap<>();

    public void addRoom(Room room,int userId1 ,int userId2) {
        rooms.put(room.getRoomId(), room);
        userIdToRoomId.put(userId2,room.getRoomId());
        userIdToRoomId.put(userId1,room.getRoomId());
    }

    public void removeRoom(String roomId,int userId1 ,int userId2) {
        rooms.remove(roomId);
        userIdToRoomId.remove(userId1);
        userIdToRoomId.remove(userId2);
    }

    public Room getRoomByRoomId(String roomId) {
        return rooms.get(roomId);
    }

    public Room getRoomByUserId(int  userId) {
        String roomId = userIdToRoomId.get(userId);
        if (roomId==null) {
            return null;
        }
        return rooms.get(roomId);
    }
}
