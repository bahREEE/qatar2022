package com.example.coupe.entities;

import java.io.IOException;
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

import com.example.coupe.Utilities.MyByte;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EquipeTBL")
@NoArgsConstructor
@AllArgsConstructor

public class Equipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "equipeName", nullable = false)
    private String equipeName;


    @Column(name = "equipeContinent", nullable = false)
        private String equipeContinent;

    @Column(name = "classementMondial", nullable = true)
    private int classementMondial;

    @OneToMany(mappedBy = "equipe")
    @JsonManagedReference
    private List<Joueur> listJoueurs;



    @Column(name = "EquipeImagePath", nullable = false)
    private String imagepath;

    @Column(name = "base64image")
    private String base64image;

    public Long getId() {
        return id;
    }

    public void setEquipeId(Long id) {
        this.id = id;
    }

    public String getEquipeName() {
        return equipeName;
    }

    public void setEquipeName(String equipeName) {
        this.equipeName = equipeName;
    }

    public String getEquipeContinent() {
        return equipeContinent;
    }

    public void setEquipeContinent(String equipeContinent) {
        this.equipeContinent = equipeContinent;
    }

    public int getClassementMondial() {
        return classementMondial;
    }

    public void setClassementMondial(int classementMondial) {
        this.classementMondial = classementMondial;
    }

    public List<Joueur> getListJoueurs() {
        return listJoueurs;
    }

    public void setListJoueurs(List<Joueur> listJoueurs) {
        this.listJoueurs = listJoueurs;
    }



    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getBase64image() throws IOException {
        if(imagepath != "" && imagepath != null){
            MyByte mb = new MyByte();
            return mb.base64encode(this.getImagepath());
        }
        else return null;
    }

    public void setBase64image(String base64image) {
        this.base64image = base64image;
    }

    

}
