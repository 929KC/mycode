package com.kc.sendbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteMessage {
    private Integer  exitValue;
    private String message;
    private String errorMessage;
    private long time;
}
