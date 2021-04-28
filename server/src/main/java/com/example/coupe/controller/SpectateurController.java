package com.example.coupe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.coupe.dao.SpectateurRepository;
import com.example.coupe.entities.Spectateur;


@RestController
@RequestMapping("/spectators")
public class SpectateurController {
    
    @Autowired
    private SpectateurRepository spectateurRepository;

    @GetMapping(value = "/")
    public List<Spectateur> listSpectators() {
        return spectateurRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Spectateur getAspectator(@PathVariable Long id) {
        return spectateurRepository.findById(id).orElseThrow();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> saveSpectator(@Validated @RequestBody Spectateur s) {
        spectateurRepository.save(s);
        return new ResponseEntity<>("Spectator was saved successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<String> deleteSpectators() {
        spectateurRepository.deleteAll();
        return new ResponseEntity<>("All spectators were deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAspectator(@PathVariable Long id) {
        spectateurRepository.deleteById(id);
        return new ResponseEntity<>("Spectator was deleted successfully !", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateSpectator(@PathVariable(name = "id") Long id,
            @RequestBody Spectateur spectateur) {
        spectateur.setSpectateurId(id);
        spectateurRepository.save(spectateur);
        return new ResponseEntity<>("Spectator was updated successfully !", HttpStatus.OK);
    }

}
