package com.example.coupe.dto;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class RegisterRequest {
    
    private String username;
    private String password;
    private String confirmedPassword;
    @Email
    private String email;

}
