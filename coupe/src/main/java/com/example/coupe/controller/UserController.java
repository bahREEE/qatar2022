package com.example.coupe.controller;

import java.util.List;

import com.example.coupe.dao.UserRepository;
import com.example.coupe.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(value = "/user/{id}")
    public User getAuser(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping(value="/saveUser")
    public ResponseEntity<String> save(@Validated @RequestBody User s){
        userRepository.save(s);
        return new ResponseEntity<>("User saved successfully !", HttpStatus.OK);
    }

    @PutMapping(value="/deleteAllusers")
    public ResponseEntity<String> deleteUsers(){
        userRepository.deleteAll();
        return new ResponseEntity<>("All users deleted successfully !", HttpStatus.OK);
    }
}
