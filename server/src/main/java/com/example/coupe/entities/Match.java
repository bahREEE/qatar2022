package com.example.coupe.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @Column(name = "match_id", insertable = false, updatable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "equipe1_id")
    private Equipe equipe1;

    private int e1goals;

    @OneToOne
    @JoinColumn(name = "equipe2_id")    
    private Equipe equipe2;

    private int e2goals;

    private Date horaire;

    private Boolean matchPlayed;

    private Boolean matchPlayoffs;

    private String terrain;



    @ManyToOne
    @JoinColumn(name="groupeId")
    private Groupe groupe;


}
