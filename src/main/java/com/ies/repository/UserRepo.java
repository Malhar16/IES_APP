package com.ies.repository;

import com.ies.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserEmail(String email);
}
