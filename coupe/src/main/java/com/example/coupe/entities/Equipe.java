package com.example.coupe.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "JoueurTBL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Equipe {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipeId;

    private String equipeName;

    private String equipeContinent;

    @OneToMany(mappedBy = "equipe")
    List<Joueur> listJoueurs;

}
