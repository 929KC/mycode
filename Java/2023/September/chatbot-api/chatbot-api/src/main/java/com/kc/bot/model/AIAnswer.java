package com.kc.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AIAnswer {
    private String id;

    private String object;

    private long created;

    private String model;
    private List<Choices> choices;

}
