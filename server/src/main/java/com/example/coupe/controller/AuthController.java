package com.example.coupe.controller;

import com.example.coupe.Services.AuthService;
import com.example.coupe.dto.AuthenticationResponse;
import com.example.coupe.dto.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

   @PostMapping(value = "/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        
      Authentication authenticate =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
      User user = (User) authenticate.getPrincipal();
       SecurityContextHolder.getContext().setAuthentication(authenticate);

        return authService.login(user);
  
    }


}
