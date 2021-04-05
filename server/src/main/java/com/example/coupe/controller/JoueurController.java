package com.example.coupe.controller;

import com.example.coupe.dao.EquipeRepository;
import com.example.coupe.dao.JoueurRepository;
import com.example.coupe.entities.Equipe;
import com.example.coupe.entities.Joueur;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class JoueurController {

    @Autowired
    private JoueurRepository joueurRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/joueurs")
    public List<Joueur> listJoueurs() {
        return joueurRepository.findAll();
    }

    @GetMapping(value = "/joueursEquipe/{id}")
    public List<Joueur> getJoueursEquipe(@PathVariable Long id){
        Equipe equipe = equipeRepository.findById(id).orElseThrow();
        return joueurRepository.findByEquipe(equipe);
            
    }

    @GetMapping(value = "/joueur/{id}")
    public Joueur getJoueur(@PathVariable Long id) throws IOException {
        
        return joueurRepository.findById(id).orElseThrow();
      
    }

    @PostMapping(value = "/saveJoueur")
    public ResponseEntity<String> saveJoueur(@RequestBody Joueur j) {
        j.setPassword(passwordEncoder.encode(j.getPassword()));
        joueurRepository.save(j);
        return new ResponseEntity<>("Joueur was saved successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAllJoueurs")
    public ResponseEntity<String> deleteJoueurs() {
        joueurRepository.deleteAll();
        return new ResponseEntity<>("All joueurs were deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteJoueur/{id}")
    public ResponseEntity<String> deleteAjoueur(@PathVariable Long id) {
        joueurRepository.deleteById(id);
        return new ResponseEntity<>("Joueur was deleted successfully !", HttpStatus.OK);
    }

    @PutMapping(value = "/updateJoueur/{id}")
    public ResponseEntity<String> updateJoueur(@PathVariable(name = "id") Long id, @RequestBody Joueur joueur) {
        joueur.setUserId(id);
        joueurRepository.save(joueur);
        return new ResponseEntity<>("Joueur was updated successfully !", HttpStatus.OK);
    }


}
