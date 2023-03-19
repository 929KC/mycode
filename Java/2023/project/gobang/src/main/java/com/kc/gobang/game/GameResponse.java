package com.kc.gobang.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameResponse {
    // 如果不给 message 设置 getter / setter, 则不会被 jackson 序列化
    private String message = "putChess";
    private int userId;
    private int row;
    private int col;
    private int winner; // 胜利玩家的 userId
}
