package com.example.coupe.controller;

import java.time.Instant;

import com.example.coupe.Config.UserDetailsServiceImpl;
import com.example.coupe.Services.AccountService;
import com.example.coupe.Services.AuthService;
import com.example.coupe.dto.AuthenticationResponse;
import com.example.coupe.dto.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/signup")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class RegisterController {
    
    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthService authService;
    @Autowired
    private UserDetailsServiceImpl userDetails;

    @PostMapping(value = "/")
    public AuthenticationResponse register(@RequestBody RegisterRequest registerRequest){
        System.out.println("hello");
         accountService.saveUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getConfirmedPassword(), registerRequest.getEmail(), 
                                Instant.now(), false,registerRequest.getRole());
        User user = (User) userDetails.loadUserByUsername(registerRequest.getUsername());
        return authService.login(user);
    }

}
