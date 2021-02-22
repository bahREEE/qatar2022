package com.example.coupe.Services;

import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

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
    public MyUser saveUser(String username, String password, String confirmedPassword, String email, Instant creationDate, Boolean activated) {
        MyUser user = userRepository.findByUsername(username);
        if(user != null) throw new RuntimeException("This user already exists !!!");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        MyUser newUser = new MyUser();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setEmail(email);
        newUser.setCreationDate(Instant.now());
        newUser.setActivated(true);
        userRepository.save(newUser);
        addRoleToUser(username,"USER");
        return newUser;
    }

    @Override
    public MyRole save(MyRole role) {
        return roleRepository.save(role);
    }

    @Override
    public MyUser loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        MyUser user = userRepository.findByUsername(username);
        MyRole role = roleRepository.findByroleName(rolename);

        user.getRoles().add(role);
    }


    
}
