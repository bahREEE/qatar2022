package com.example.coupe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import com.example.coupe.dao.EquipeRepository;
import com.example.coupe.dao.GroupeRepository;
import com.example.coupe.entities.Equipe;
import com.example.coupe.entities.Groupe;

@RestController
public class GroupeController {
    
    @Autowired
    private GroupeRepository groupeRepository;
    @Autowired
    private EquipeRepository equipeRepository;

    
    @GetMapping(value = "/groupes")
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }

    @Secured(value = {"USER"})
    @GetMapping(value = "/groupe/{id}")
    public Groupe getGroupe(@PathVariable Long id) {
        return groupeRepository.findById(id).orElseThrow();
    }

    
@GetMapping(value = "/equipesGroupe/{id}")
public List<Equipe> getEquipesGroupe(@PathVariable Long id){

	Groupe groupe = groupeRepository.findById(id).orElseThrow();
	return equipeRepository.findByGroupe(groupe);

}

    @DeleteMapping(value = "/deleteAllgroupes")
    public ResponseEntity<String> deleteAllGroupes(){
        groupeRepository.deleteAll();
        return new ResponseEntity<>("All groupes were deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteGroupe/{id}")
    public ResponseEntity<String> deleteGroupe(@PathVariable Long id){
        groupeRepository.deleteById(id);
        return new ResponseEntity<>("Groupe was deleted successfully !", HttpStatus.OK);
    }

    @PostMapping(value = "/addGroupe")
    public ResponseEntity<String> addGroupe(@RequestBody Groupe g){
        groupeRepository.save(g);
        return new ResponseEntity<>("Groupe was added successfully !", HttpStatus.OK);
    }
    

}
