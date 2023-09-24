package com.example.demo7.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.index.Indexed;


@Data
@Builder

public class Address {

    @Indexed
    private String city;
    @Indexed
    private String country;

}
