package com.kc.jsp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String gender;
    private String username;
    private String card;
    private String phone;
    private String address;
}
