package com.example.learnKafka.notification_service.consumer;

import com.example.learnKafka.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


//error during connect: Get "http://%2F%2F.%2Fpipe%2FdockerDesktopLinuxEngine/v1.47/containers/json?filters=%7B%22label%22%3A%7B%22com.docker.compose.config-hash%22%3Atrue%2C%22com.docker.compose.oneoff%3DFalse%22%3Atrue%2C%22com.docker.compose.project%3Dmicroservices%22%3Atrue%7D%7D": open //./pipe/dockerDesktopLinuxEngine: The system cannot find the file specified.

@Service
@Slf4j
public class UserKafkaConsumer {

    @KafkaListener(topics ="user-created-topic")
    public void handleUserCreatedTopic(UserCreatedEvent userCreatedEvent){
        log.info("handleUserCreatedEvent:{}",userCreatedEvent);
    }

    @KafkaListener(topics ="user-random-topic")
    public void handleUserRandomTopic1(String message){
        log.info("Handle User Random Topic1:{}",message);
    }
    @KafkaListener(topics ="user-random-topic")
    public void handleUserRandomTopic2(String message){
        log.info("Handle User Random Topic2:{}",message);
    }
    @KafkaListener(topics ="user-random-topic")
    public void handleUserRandomTopic3(String message){
        log.info("Handle User Random Topic3:{}",message);
    }
}
