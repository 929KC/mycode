package com.kc.gobang.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameReadyResponse {
    private String message = "gameReady";
    private boolean ok = true;
    private String reason = "";
    private String roomId = "";
    private int thisUserId = 0;
    private int thatUserId = 0;
    private int whiteUserId = 0;
}
