package com.example.coupe.dao;

import com.example.coupe.entities.Spectateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpectateurRepository extends JpaRepository<Spectateur, Long>{

    
}
