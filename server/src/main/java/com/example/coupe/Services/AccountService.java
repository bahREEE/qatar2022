package com.example.coupe.Services;

import java.time.Instant;

import com.example.coupe.entities.MyRole;
import com.example.coupe.entities.MyUser;

public interface AccountService {
    
    public MyUser saveUser(String username, String password, String confirmedPassword, String email, Instant creationDate, Boolean activated);
    public MyRole save(MyRole role);
    public MyUser loadUserByUsername(String username);
    public void addRoleToUser(String username, String rolename);

}
