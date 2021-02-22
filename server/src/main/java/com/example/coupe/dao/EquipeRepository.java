package com.example.coupe.dao;

import java.util.List;

import com.example.coupe.entities.Equipe;
import com.example.coupe.entities.Groupe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long>{

	List<Equipe> findByGroupe(Groupe groupe);
    
}
