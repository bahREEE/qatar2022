package com.example.coupe.dao;

import com.example.coupe.entities.Groupe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long>{
    
}
