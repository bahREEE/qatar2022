package com.example.coupe.Services;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.coupe.dto.AuthenticationResponse;
import com.example.coupe.dto.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import static com.example.coupe.Config.SecurityConstants.SECRET;
import static com.example.coupe.Config.SecurityConstants.EXPIRATION_TIME;
import static com.example.coupe.Config.SecurityConstants.TOKEN_PREFIX;
import static com.example.coupe.Config.SecurityConstants.HEADER_STRING;

@Service
public class AuthService {
    
    

    public AuthenticationResponse login(User user){

        
        String jwt = JWT.create()
                    .withSubject(user.getUsername())
                    .withArrayClaim("roles", user.getAuthorities().toArray(new String[user.getAuthorities().size()]))
                    .withExpiresAt(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                    .sign(Algorithm.HMAC512(SECRET.getBytes()));
                    
        return new AuthenticationResponse(user,jwt);
    }
}
