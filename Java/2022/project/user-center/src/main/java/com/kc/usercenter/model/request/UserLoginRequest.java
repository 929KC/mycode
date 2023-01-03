package com.kc.usercenter.model.request;

import lombok.Data;
import java.io.Serializable;
@Data
public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = 8126739830373626993L;

     private String userAccount;
     private  String userPassword;
}
