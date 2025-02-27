package com.example.learnKafka.user_services.event;

import lombok.Data;

@Data
public class UserCreatedEvent {
    private Long id;
    private String email;
}
