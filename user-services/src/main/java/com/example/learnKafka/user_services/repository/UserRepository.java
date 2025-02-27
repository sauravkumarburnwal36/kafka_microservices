package com.example.learnKafka.user_services.repository;

import com.example.learnKafka.user_services.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
