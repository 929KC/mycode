package com.kc.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = -332930684841802800L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
