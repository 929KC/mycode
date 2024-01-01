package com.kc.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topics {
    private long topic_id;

    private Group group;

    private String type;

    private Question question;

    private boolean answered;

    private long likes_count;

    private long rewards_count;

    private long comments_count;
    private long reading_count;

    private long readers_count;

    private boolean digested;

    private boolean sticky;

    private String create_time;

    private UserSpecific user_specific;
}