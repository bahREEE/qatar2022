package com.example.coupe.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.coupe.dao.ArbitreRepository;
import com.example.coupe.dao.MatchRepository;
import com.example.coupe.entities.Arbitre;
import com.example.coupe.entities.Match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matches")
public class MatchController {
    
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ArbitreRepository arbitreRepository;

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
        Arbitre a = new Arbitre();
        a = arbitreRepository.findById(match.getArbitre().getArbitreId()).orElseThrow();
        a.addmatch(match);
        arbitreRepository.save(a);
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
