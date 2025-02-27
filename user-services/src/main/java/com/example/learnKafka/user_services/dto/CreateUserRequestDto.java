package com.example.learnKafka.user_services.dto;

import lombok.Data;

@Data
public class CreateUserRequestDto {
    private Long id;
    private String name;
    private String email;
}
