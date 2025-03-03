package com.example.learnKafka.user_services.service;

import com.example.learnKafka.event.UserCreatedEvent;
import com.example.learnKafka.user_services.dto.CreateUserRequestDto;
import com.example.learnKafka.user_services.entity.User;
import com.example.learnKafka.user_services.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final KafkaTemplate<Long, UserCreatedEvent> kafkaTemplate;

    @Value("${kafka.topic.user-created-topic}")
    private String KAFKA_USER_CREATED_TOPIC;

    public void createUser(CreateUserRequestDto createUserRequestDto) {
        User user=modelMapper.map(createUserRequestDto,User.class);
        User savedUser=userRepository.save(user);
        UserCreatedEvent userCreatedEvent=modelMapper.map(savedUser,UserCreatedEvent.class);
        kafkaTemplate.send(KAFKA_USER_CREATED_TOPIC,userCreatedEvent.getId(),userCreatedEvent);
    }
}
