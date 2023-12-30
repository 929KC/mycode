package com.kc.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UnAnsweredQuestionsAggregates {

    private boolean succeeded;

    private RespData resp_data;
}
