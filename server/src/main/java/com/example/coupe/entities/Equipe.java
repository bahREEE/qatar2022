package com.example.coupe.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//testing
@Entity
@Table(name = "EquipeTBL")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Equipe {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipeId;

    @Column(name = "equipeName", nullable = false)
    private String equipeName;

    
    @Column(name = "equipeContinent", nullable = false)
    private String equipeContinent;

    @Column(name = "classementMondial", nullable = true)
    private int classementMondial;

    @OneToMany(mappedBy = "equipe")
    @JsonIgnore
    private List<Joueur> listJoueurs;
    
    @ManyToOne
    @JoinColumn(name="groupeId")
    private Groupe groupe;
    
    @Column(name = "EquipeImagePath", nullable = false)
    private String imagepath;

    @Column(name = "EquipeImageBytes", nullable = true)
    private byte[] imageBytes;

    @Nullable
    private String base64image;

}
