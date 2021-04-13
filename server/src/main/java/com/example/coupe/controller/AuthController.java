package com.example.coupe.controller;

import com.example.coupe.dao.UserRepository;
import com.example.coupe.dto.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import com.example.coupe.Services.AuthService;
import com.example.coupe.dao.UserRepository;
import com.example.coupe.dto.AuthenticationResponse;
import com.example.coupe.dto.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
*/
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

   @Autowired
   //private UserRepository userRepository;



    @PostMapping(value = "/login")
    public String login(@RequestBody RegisterRequest loginRequest){

        return "hello";
    }


}
