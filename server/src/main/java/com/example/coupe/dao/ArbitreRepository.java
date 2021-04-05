package com.example.coupe.dao;

import com.example.coupe.entities.Arbitre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long>{
    
}
