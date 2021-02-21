package com.example.coupe.Services;

import java.time.Instant;

import com.example.coupe.entities.MyRole;
import com.example.coupe.entities.User;

public interface AccountService {
    
    public User saveUser(String username, String password, String confirmedPassword, String email, Instant creationDate, Boolean activated);
    public MyRole save(MyRole role);
    public User loadUserByUsername(String username);
    public void addRoleToUser(String username, String rolename);

}
