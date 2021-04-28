package com.example.coupe.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.coupe.dao.MatchRepository;
import com.example.coupe.entities.Match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class MatchController {
    
    @Autowired
    private MatchRepository matchRepository;


    @GetMapping("/")
    public List<Match> getmatches(){
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Match getmatch(@PathVariable Long id){
        return matchRepository.findById(id).orElseThrow();
    }

    @PostMapping("/")
    public Match addmatch(@RequestBody Match match){
        System.out.println(match.getEquipe1());
        return matchRepository.save(match);
    }

    @DeleteMapping("/")
    public List<Match> deletematches(){
        List<Match> l = new ArrayList<>();
        l = matchRepository.findAll();
        matchRepository.deleteAll();
        return l;
    }

    @DeleteMapping("/{id}")
    public Match deletematch(@PathVariable Long id){
        Match m = new Match();
        m = matchRepository.findById(id).orElseThrow();
        matchRepository.deleteById(id);
        return m;
    }
}
