package com.example.learnKafka.user_services.controller;

import com.example.learnKafka.user_services.dto.CreateUserRequestDto;
import com.example.learnKafka.user_services.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Value("${kafka.topic.user-random-topic}")
    private String KAFKA_USER_RANDOM_TOPIC;

    private final KafkaTemplate<String,String> kafkaTemplate;

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        userService.createUser(createUserRequestDto);
        return ResponseEntity.ok("User is created");
    }

    @PostMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message){

        for(int i=0;i<1000;i++) {
            kafkaTemplate.send(KAFKA_USER_RANDOM_TOPIC,""+i%3, message+i);
        }
        return ResponseEntity.ok("Message Queued");
    }
}
