package com.kc.bot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionee {
    private long user_id;

    private String name;

    private String avatar_url;

    private String location;
}