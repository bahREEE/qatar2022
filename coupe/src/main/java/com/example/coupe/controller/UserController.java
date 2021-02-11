package com.example.coupe.controller;

import java.util.List;

import com.example.coupe.dao.UserRepository;
import com.example.coupe.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/coupe")
@AllArgsConstructor
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users")
    public List<User> listUsers(){
        return userRepository.findAll();
    }


    @PostMapping(value="/saveUser")
    public User save(@RequestBody User s){
        return userRepository.save(s);
    }
}
