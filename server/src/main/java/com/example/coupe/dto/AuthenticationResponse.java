package com.example.coupe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.userdetails.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticationResponse {

    private User user;
    private String token;


}
