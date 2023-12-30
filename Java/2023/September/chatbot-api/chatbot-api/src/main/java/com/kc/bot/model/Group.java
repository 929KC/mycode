package com.kc.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    private long group_id;

    private String name;

    private String type;

    private String background_url;

}
