package com.example.TetsTaskSecurity.controller;

import com.example.TetsTaskSecurity.entity.UserEntity;
import com.example.TetsTaskSecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationContoller {
    UserService userService ;
    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userEntity", new UserEntity());
        return "registration" ;
    }
    @PostMapping ("/registration")
    public String  registration(@ModelAttribute ("userEntity")  UserEntity  userEntity,Model model){
        userService.sabeUser(userEntity);
        return "redirect:/login" ;

    }
}
