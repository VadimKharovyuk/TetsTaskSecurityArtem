package com.example.TetsTaskSecurity.security;

import com.example.TetsTaskSecurity.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
@NoArgsConstructor
@Getter
@Setter

public class UserDetalisImpl  implements UserDetails {
    private Long id;
    private String name;
    private String email;
    private String password ;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetalisImpl(Long id, String name, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    public static UserDetalisImpl build(UserEntity userEntity){
        List<GrantedAuthority> authorityList = List.of(new SimpleGrantedAuthority(userEntity.getRole().name()));
        return new UserDetalisImpl(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                authorityList);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
