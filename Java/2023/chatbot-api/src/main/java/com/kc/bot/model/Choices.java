package com.kc.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Choices {
    private Message message;

    private String logprobs;

    private String finish_reason;

    private long index;
}