package com.example.TetsTaskSecurity.repo;

import com.example.TetsTaskSecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<UserEntity,Long> {
}
