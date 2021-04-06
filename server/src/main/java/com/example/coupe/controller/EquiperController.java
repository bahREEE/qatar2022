package com.example.coupe.controller;

import java.util.List;

import com.example.coupe.dao.EquipeRepository;
import com.example.coupe.entities.Equipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EquiperController {
    
    @Autowired
    private EquipeRepository equipeRepository;


    @GetMapping(value = "/equipes")
    public List<Equipe> getAllEquipe() {

        return equipeRepository.findAll();
    }

    @GetMapping(value = "/equipe/{id}")
    public Equipe getEquipe(@PathVariable Long id) {
        return equipeRepository.findById(id).orElseThrow();
    }

    @PostMapping(value="/saveEquipe")
    public ResponseEntity<String> addEquipe(@RequestBody Equipe e){
        System.out.println(e.getGroupe().getGroupeId());
        equipeRepository.save(e);
        return new ResponseEntity<>("Equipe was added successfully !", HttpStatus.OK);
    }

    @PutMapping(value = "/updateEquipe/{id}")
    public ResponseEntity<String> updateEquipe(@PathVariable(name = "id") Long id, @RequestBody Equipe equipe) {
        equipe.setEquipeId(id);
        equipeRepository.save(equipe);
        return new ResponseEntity<>("Equipe was updated successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAllequipes")
    public ResponseEntity<String> deleteEquipes(){
        equipeRepository.deleteAll();
        return new ResponseEntity<>("All equipes were deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteEquipe/{id}")
    public ResponseEntity<String> deleteEquipe(@PathVariable Long id){
        equipeRepository.deleteById(id);
        return new ResponseEntity<>("Equipe was deleted successfully !", HttpStatus.OK);
    }



}
