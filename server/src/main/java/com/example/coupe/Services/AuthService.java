package com.example.coupe.Services;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.coupe.dto.AuthenticationResponse;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import static com.example.coupe.Config.SecurityConstants.SECRET;
import static com.example.coupe.Config.SecurityConstants.EXPIRATION_TIME;

@Service
public class AuthService {
    
    

    public AuthenticationResponse login(User user){



        
        String jwt = JWT.create()
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                    .sign(Algorithm.HMAC512(SECRET.getBytes()));
                    
        return new AuthenticationResponse(user,jwt);
    }
}
