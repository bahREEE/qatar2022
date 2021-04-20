package com.example.coupe.controller;

import com.example.coupe.dao.ArbitreRepository;
import com.example.coupe.entities.Arbitre;

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
public class ArbitreController {
    
    @Autowired
    private ArbitreRepository arbitreRepository;


    @GetMapping(value = "/arbitres")
    public ResponseEntity<String> getarbitres(){
        arbitreRepository.findAll();
        return new ResponseEntity<>("Success !", HttpStatus.OK);
    }

    @GetMapping(value = "/arbitre/{id}")
    public ResponseEntity<String> getarbtire(@PathVariable Long id){
        arbitreRepository.findById(id);
        return new ResponseEntity<>("Success !", HttpStatus.OK);
    }

    @PostMapping(value = "/savearbitre")
    public ResponseEntity<String> ajoutarbitre(@RequestBody Arbitre arbitre){
        arbitreRepository.save(arbitre);
        return new ResponseEntity<>("Arbitre added successfully !", HttpStatus.OK);
    }


    @PutMapping(value = "/updatearbitre/{id}")
    public ResponseEntity<String> modifarbitre(@RequestBody Arbitre arbitre,@PathVariable(name="id") Long id){
        arbitre.setArbitreId(id);
        arbitreRepository.save(arbitre);       
        return new ResponseEntity<>("Arbitre updated successfully !", HttpStatus.OK);
    }


    @DeleteMapping(value = "/deletearbitre/{id}")
    public ResponseEntity<String> supparbitre(@PathVariable Long id){
        arbitreRepository.deleteById(id);
        return new ResponseEntity<>("Arbitre deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteallarbitres")
    public ResponseEntity<String> suppallarbitres(){
        arbitreRepository.deleteAll();
        return new ResponseEntity<>("All arbitres deleted successfully !", HttpStatus.OK);
    }


}
