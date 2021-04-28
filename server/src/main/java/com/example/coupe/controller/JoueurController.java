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

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/joueurs")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class JoueurController {

    @Autowired
    private JoueurRepository joueurRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping(value = "/")
    public List<Joueur> listJoueurs() {
        return joueurRepository.findAll();
    }

    @GetMapping(value = "/equipe/{id}")
    public List<Joueur> getJoueursEquipe(@PathVariable Long id){
        Equipe equipe = equipeRepository.findById(id).orElseThrow();
        System.out.println(equipe.getListJoueurs().size());
        return equipe.getListJoueurs();
            
    }

    @GetMapping(value = "/{id}")
    public Joueur getJoueur(@PathVariable Long id) throws IOException {
        
        return joueurRepository.findById(id).orElseThrow();
      
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> saveJoueur(@RequestBody Joueur j) {
        joueurRepository.save(j);
        return new ResponseEntity<>("Joueur was saved successfully !", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public Joueur updatejoueur(@PathVariable(name = "id") Long id, @RequestBody Joueur joueur){
        joueur.setJoueurId(id);
        joueurRepository.save(joueur);
        return joueur;
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<String> deleteJoueurs() {
        joueurRepository.deleteAll();
        return new ResponseEntity<>("All joueurs were deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAjoueur(@PathVariable Long id) {
        joueurRepository.deleteById(id);
        return new ResponseEntity<>("Joueur was deleted successfully !", HttpStatus.OK);
    }

}
