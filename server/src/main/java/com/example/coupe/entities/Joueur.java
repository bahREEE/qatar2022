package com.example.coupe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name="jfirst", nullable=false)
    private String jfirst;

    @Column(name="jlast", nullable=false)
    private String jlast;

    @Column(name="jnumber", nullable=false)
    private int jnumber;

    @JsonIgnore
    private String imagepath;

    @ManyToOne
    @JoinColumn(name="equipeId")
    private Equipe equipe;

}
