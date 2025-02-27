package com.example.learnKafka.notification_service.consumer;

import com.example.learnKafka.user_services.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

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
