package com.example.coupe.controller;

import java.util.List;

import com.example.coupe.dao.ArbitreRepository;
import com.example.coupe.entities.Arbitre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/arbitres")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class ArbitreController {
    
    @Autowired
    private ArbitreRepository arbitreRepository;


    @GetMapping(value = "/")
    public List<Arbitre> getarbitres(){
        return arbitreRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Arbitre getarbtire(@PathVariable Long id){
        return arbitreRepository.findById(id).orElseThrow();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> ajoutarbitre(@RequestBody Arbitre arbitre){
        arbitreRepository.save(arbitre);
        return new ResponseEntity<>("Arbitre added successfully !", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> modifarbitre(@RequestBody Arbitre arbitre,@PathVariable(name="id") Long id){
        arbitre.setArbitreId(id);
        arbitreRepository.save(arbitre);       
        return new ResponseEntity<>("Arbitre updated successfully !", HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> supparbitre(@PathVariable Long id){
        arbitreRepository.deleteById(id);
        return new ResponseEntity<>("Arbitre deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<String> suppallarbitres(){
        arbitreRepository.deleteAll();
        return new ResponseEntity<>("All arbitres deleted successfully !", HttpStatus.OK);
    }


}
