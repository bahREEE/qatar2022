package com.example.coupe.dao;

import com.example.coupe.entities.Equipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long>{
    
}
