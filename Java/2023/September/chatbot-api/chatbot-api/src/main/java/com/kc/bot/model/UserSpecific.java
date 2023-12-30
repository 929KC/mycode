package com.kc.bot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSpecific {

    private boolean liked;

    private boolean subscribed;

}
