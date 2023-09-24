package com.example.demo7.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;

@Data
@RedisHash("persons")
@Builder
public class Person {
    @Id
    private String id;
    @Indexed
    private String firstName;
    @Indexed
    private String lastName;
    private Address address;

    private List<Family> families ;
}
