package com.kc.gobang.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponse {
    private boolean ok = true;
    private String reason = "";
    private String message = "";
}
