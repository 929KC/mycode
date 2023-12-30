package com.kc.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usage {
    private long prompt_tokens;

    private long completion_tokens;

    private long total_tokens;

}