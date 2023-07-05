package com.kc.onlineoj.compile;

import lombok.Data;

/**
 * Task执行结果
 */
@Data
public class Answer {
    private int error;
    private String reason;
    private String stdout;
    private String stderr;
}
