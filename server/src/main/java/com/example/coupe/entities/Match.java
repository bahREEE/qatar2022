package com.example.coupe.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MatchTBL")
public class Match {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

/*
    @Autowired
    private Equipe equipe1;

    private int e1goals;

    @Autowired
    private Equipe equipe2;

    private int e2goals;
*/    

    private Date horaire;

    private Boolean matchPlayed;

    private Boolean matchPlayoffs;

    private String Terrain;

    @ManyToOne(optional = false)
    @JoinColumn(name = "matchId", insertable = false, updatable = false)
    private Arbitre arbitre;


}
