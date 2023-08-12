package org.example.Functional.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;

    public void pr(){
        System.out.println("Hello Wrorld");
    }
    public static void pr(String username){
        System.out.println("Hello World:"+username);
    }
}
