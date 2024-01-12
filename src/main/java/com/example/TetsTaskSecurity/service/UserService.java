package com.example.TetsTaskSecurity.service;

import com.example.TetsTaskSecurity.entity.UserEntity;
import com.example.TetsTaskSecurity.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    UserRepo userRepo ;
    private BCryptPasswordEncoder encoder(){ return new BCryptPasswordEncoder();

    }
    public void sabeUser(UserEntity userEntity){
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepo.save(userEntity);


    }

    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }
}
