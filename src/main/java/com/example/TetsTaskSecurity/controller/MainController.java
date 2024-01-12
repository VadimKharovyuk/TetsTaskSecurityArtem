package com.example.TetsTaskSecurity.controller;

import com.example.TetsTaskSecurity.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    UserService userService ;
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("users",userService.getAll());
        return "main";
    }
    @GetMapping ("/login")
    public String login(){
        return "login" ;
    }
}
