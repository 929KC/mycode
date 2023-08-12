package org.example.Functional;



import org.example.Functional.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Demo8 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User("张三", "2222"), new User("李四", "3333")
                , new User("王五", "4444"));
      users.stream().map(User::getUsername).map(StringBuilder::new)
              .map(sb->sb.append("cdd").toString()).forEach(System.out::println);
    }
}