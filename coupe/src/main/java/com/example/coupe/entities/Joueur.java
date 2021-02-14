package com.example.coupe.entities;

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

@Entity
@Table(name = "JoueurTBL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Joueur {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long joueurId;

    private String jFirstName;

    private String jLastName;

    private int jNumber;

    @ManyToOne
    @JoinColumn(name="equipeId", nullable = true)
    private Equipe equipe;

}
