package com.kc.hotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String email;
    private String userName;
    private String password;
    private Integer sex;
    private String phone;


}
