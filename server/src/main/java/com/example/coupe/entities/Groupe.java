package com.example.coupe.entities;

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
@Table(name = "GroupeTBL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Groupe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupeId;

    private Character groupeName;

    @OneToMany(mappedBy = "equipe")
    private Equipe[] equipes;

}
