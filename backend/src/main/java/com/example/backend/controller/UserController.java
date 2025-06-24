package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.User;
import com.example.backend.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@CrossOrigin
public class UserController {
    
    @Autowired
    UserService ser;
    @PostMapping("/postuser")
    public User postMethodName(@RequestBody User u) {
        //TODO: process POST request
        
        return ser.registerUser(u);
    }

    @GetMapping("/login")
    public User getMethodName(@RequestBody User u) {
        return ser.Login(u);
    }
    
    
}
