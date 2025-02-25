package com.example.learnKafka.notification_service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserKafkaConsumer {

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
