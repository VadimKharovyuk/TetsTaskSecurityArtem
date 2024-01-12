package com.example.TetsTaskSecurity.security;

import com.example.TetsTaskSecurity.entity.UserEntity;
import com.example.TetsTaskSecurity.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDevitalisesImpl implements UserDetailsService {
    UserRepo userRepo ;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("Польователь с  таким email "+username+" не найден"));
        return UserDetalisImpl.build(userEntity);
    }
}
