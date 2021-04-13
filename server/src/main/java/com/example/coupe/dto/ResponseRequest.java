package com.example.coupe.dto;

import com.example.coupe.entities.MyUser;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

@Data
public class ResponseRequest {

    private MyUser user;
    private String token;

    public ResponseRequest(User user, String jwt) {
    }
}
