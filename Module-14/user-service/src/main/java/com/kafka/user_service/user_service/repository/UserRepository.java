package com.kafka.user_service.user_service.repository;


import com.kafka.user_service.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
