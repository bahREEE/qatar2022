package com.example.coupe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import com.example.coupe.dao.GroupeRepository;
import com.example.coupe.entities.Equipe;
import com.example.coupe.entities.Groupe;

@RestController
@RequestMapping("/groupes")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class GroupeController {
    
    @Autowired
    private GroupeRepository groupeRepository;

    
    @GetMapping(value = "/")
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    @Secured(value = {"USER"})
    @GetMapping(value = "/{id}")
    public Groupe getGroupe(@PathVariable Long id) {
        return groupeRepository.findById(id).orElseThrow();
    }

    
    @GetMapping(value = "/{id}/equipes")
    public Set<Equipe> getEquipesGroupe(@PathVariable Long id){
        Groupe groupe = groupeRepository.findById(id).orElseThrow();
        return groupe.getEquipes();

}

    @DeleteMapping(value = "/")
    public ResponseEntity<String> deleteAllGroupes(){
        groupeRepository.deleteAll();
        return new ResponseEntity<>("All groupes were deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteGroupe(@PathVariable Long id){
        groupeRepository.deleteById(id);
        return new ResponseEntity<>("Groupe was deleted successfully !", HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> addGroupe(@RequestBody Groupe g){
        groupeRepository.save(g);
        return new ResponseEntity<>("Groupe was added successfully !", HttpStatus.OK);
    }
    

}
