package org.example.Functional.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String username;
    private String password;
    public int age ;


    public  String pr(String username){
      return username;
    }
}
