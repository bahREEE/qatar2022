package com.example.coupe.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.example.coupe.dao.RoleRepository;
import com.example.coupe.dao.UserRepository;
import com.example.coupe.dto.UserRequest;
import com.example.coupe.entities.ERole;
import com.example.coupe.entities.MyRole;
import com.example.coupe.entities.MyUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value = "/")
    @PreAuthorize("hasRole('ADMIN')")
    public List<MyUser> getusers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public MyUser getUser(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping(value = "/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addUser(@RequestBody UserRequest user){
        System.out.println(user.getRole());
        MyUser newUser = new MyUser();
        newUser.setUsername((user.getUsername()));
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setCreationDate(Instant.now());
        addRoleToUser(newUser,user.getRole());
        userRepository.save(newUser);       
        return new ResponseEntity<>("User added successfully", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateuser(@PathVariable(name = "id") Long id, @RequestBody MyUser user){
        user.setUserId(id);
        userRepository.save(user);
        return new ResponseEntity<>("User updated successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteallusers(){
        userRepository.deleteAll();
        return new ResponseEntity<>("All users deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteauser(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    private void addRoleToUser(MyUser user, String role) {

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
