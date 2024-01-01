package com.kc.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Owner owner;

    private Questionee questionee;

    private String text;

    private boolean expired;

    private boolean anonymous;

    private OwnerDetail owner_detail;

    private String owner_location;

}