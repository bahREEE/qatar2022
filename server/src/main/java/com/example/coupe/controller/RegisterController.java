package com.example.coupe.controller;

import java.time.Instant;

import com.example.coupe.Services.AccountService;
import com.example.coupe.dto.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RegisterController {
    
    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/signup")
    public String register(@RequestBody RegisterRequest registerRequest){

         accountService.saveUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getConfirmedPassword(), registerRequest.getEmail(), 
                                Instant.now(), false,registerRequest.getRole());

                                return "User signed up successfully !";
    }

}
