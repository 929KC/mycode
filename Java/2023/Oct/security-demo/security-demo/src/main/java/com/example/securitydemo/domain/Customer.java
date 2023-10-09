package com.example.securitydemo.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity(name = "t_customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;

}
