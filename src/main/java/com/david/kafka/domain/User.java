package com.david.kafka.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private Double height;
    private Instant createdAt;

}
