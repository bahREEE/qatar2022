package com.example.coupe.Services;

import com.example.coupe.entities.ERole;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.example.coupe.dao.RoleRepository;
import com.example.coupe.dao.UserRepository;
import com.example.coupe.entities.MyRole;
import com.example.coupe.entities.MyUser;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
 
    @Override
    public MyUser saveUser(String username, String password, String confirmedPassword, String email, Instant creationDate, Boolean activated,String role) {
        MyUser user = userRepository.findByUsername(username);
        if(user != null) throw new RuntimeException("This user already exists !!!");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        MyUser newUser = new MyUser();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setEmail(email);
        newUser.setCreationDate(Instant.now());
        addRoleToUser(newUser,role);
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void addRoleToUser(MyUser user, String role) {
        List<MyRole>roles=new ArrayList<>();
        switch (role){
            case "ROLE_USER":roles.add(roleRepository.findByroleName(ERole.ROLE_USER));
            break;
            case "ROLE_ADMIN":roles.add(roleRepository.findByroleName(ERole.ROLE_ADMIN));
            break;
            default: new RuntimeException("Error: Role not found!");

        
    }



        user.setRoles(roles);
    }


    
}
