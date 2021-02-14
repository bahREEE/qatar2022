package com.example.coupe.dao;

import com.example.coupe.entities.Joueur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long>{
    
}