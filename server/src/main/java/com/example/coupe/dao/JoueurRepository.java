package com.example.coupe.dao;

import java.util.List;

import com.example.coupe.entities.Equipe;
import com.example.coupe.entities.Joueur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long>{

	public List<Joueur> findByEquipe(Equipe equipe);

}
