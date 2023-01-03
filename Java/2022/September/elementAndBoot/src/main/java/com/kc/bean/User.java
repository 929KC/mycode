package com.kc.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)//？
public class User {
    private String id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dir;
    private String sex;
    private  String address;
}
