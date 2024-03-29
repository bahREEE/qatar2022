package com.example.coupe.dao;

import com.example.coupe.entities.MyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long>{

	MyUser findByUsername(String username);
    
}
