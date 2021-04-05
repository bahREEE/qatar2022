package com.example.coupe.dao;

import com.example.coupe.entities.Match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long>{
    
}
