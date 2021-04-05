package com.example.coupe.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Arbitre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arbitreId;

    private String arbitreNom;

    @OneToMany(mappedBy = "arbitre", cascade = CascadeType.ALL)
    private List<Match> matches;
}
