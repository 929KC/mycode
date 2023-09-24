package com.example.demo7.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.index.Indexed;

@Data
@Builder
public class Family {
    @Indexed
    private String type;
    @Indexed
    private String userName;
}
