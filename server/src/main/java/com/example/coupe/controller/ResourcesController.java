package com.example.coupe.controller;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.coupe.Services.ByteService;
import com.example.coupe.Services.UploadService;

import com.example.coupe.dao.EquipeRepository;
import com.example.coupe.dao.JoueurRepository;
import com.example.coupe.dao.SpectateurRepository;

import com.example.coupe.entities.Equipe;
import com.example.coupe.entities.Joueur;
import com.example.coupe.entities.Spectateur;


@RestController
@RequestMapping("/coupe")
public class ResourcesController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ByteService byteService;

    @Autowired
    private SpectateurRepository spectateurRepository;
    @Autowired
    private JoueurRepository joueurRepository;
    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping(value = "/spectators")
    public List<Spectateur> listSpectators() {
        return spectateurRepository.findAll();
    }

    @GetMapping(value = "/spectator/{id}")
    public Spectateur getAspectator(@PathVariable Long id) {
        return spectateurRepository.findById(id).orElseThrow();
    }

    @PostMapping(value = "/saveSpectator")
    public ResponseEntity<String> saveSpectator(@Validated @RequestBody Spectateur s) {
        spectateurRepository.save(s);
        return new ResponseEntity<>("Spectator was saved successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAllSpectators")
    public ResponseEntity<String> deleteSpectators() {
        spectateurRepository.deleteAll();
        return new ResponseEntity<>("All spectators were deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteSpectator/{id}")
    public ResponseEntity<String> deleteAspectator(@PathVariable Long id) {
        spectateurRepository.deleteById(id);
        return new ResponseEntity<>("Spectator was deleted successfully !", HttpStatus.OK);
    }

    @PutMapping(value = "/updateSpectator/{id}")
    public ResponseEntity<String> updateSpectator(@PathVariable(name = "id") Long id,
            @RequestBody Spectateur spectateur) {
        spectateur.setUserId(id);
        spectateurRepository.save(spectateur);
        return new ResponseEntity<>("Spectator was updated successfully !", HttpStatus.OK);
    }

    @GetMapping(value = "/joueurs")
    public List<Joueur> listJoueurs() {
        return joueurRepository.findAll();
    }

    @GetMapping(value = "/joueur/{id}")
    public Joueur getJoueur(@PathVariable Long id) throws IOException {
        Joueur j = new Joueur();
        j = joueurRepository.findById(id).orElseThrow();
        byteService.makeBytes(j);
        return j;
    }

    @PostMapping(value="/saveJoueur")
    public ResponseEntity<String> saveJoueur(@RequestBody Joueur j){
        joueurRepository.save(j);
        return new ResponseEntity<>("Joueur was saved successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteAllJoueurs")
    public ResponseEntity<String> deleteJoueurs(){
        joueurRepository.deleteAll();
        return new ResponseEntity<>("All joueurs were deleted successfully !", HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteJoueur/{id}")
    public ResponseEntity<String> deleteAjoueur(@PathVariable Long id){
        joueurRepository.deleteById(id);
        return new ResponseEntity<>("Joueur was deleted successfully !", HttpStatus.OK);
    }

    @PutMapping(value="/updateJoueur/{id}")
    public ResponseEntity<String> updateJoueur(@PathVariable(name="id") Long id,@RequestBody Joueur joueur){
        joueur.setUserId(id);
        joueurRepository.save(joueur);
        return new ResponseEntity<>("Joueur was updated successfully !", HttpStatus.OK);
    }
    
    @GetMapping(value="/equipes")
    public List <Equipe> getAllEquipe(){
    	
    	return equipeRepository.findAll();
    }
    
    
    @GetMapping(value = "/equipe/{id}")
    public Equipe getEquipe(@PathVariable Long id){
        return equipeRepository.findById(id).orElseThrow();
    }

    
    @PostMapping(value="/saveEquipe")
    public ResponseEntity<String> addEquipe(@RequestBody Equipe e){
       // joueur.setJoueurId(id);
        equipeRepository.save(e);
        return new ResponseEntity<>("Equipe was added successfully !", HttpStatus.OK);
    }
    
    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile){
    
        try {
			uploadService.saveImage(imageFile);
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("Error uploading image !!!");
		}

        return "Image uploaded successfully!";
    }

}
