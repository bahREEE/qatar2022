package com.example.coupe.entities;

import java.io.IOException;

import javax.persistence.*;

import com.example.coupe.Utilities.MyByte;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JoueurTBL")
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "jfirst", nullable = false)
    private String jfirst;

    @Column(name = "jlast", nullable = false)
    private String jlast;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "jnumber", nullable = false)
    private int jnumber;

    @Column(name = "imagepath", nullable = false)
    private String imagepath;

    @Column(name = "base64image")
    private String base64;

    @ManyToOne
    @JoinColumn(name = "equipeId")
    @JsonBackReference
    private Equipe equipe;


    public Long getId(){
        return id;
    }

    public void setJoueurId(Long id){
        this.id = id;
    }

    public String getJfirst() {
        return jfirst;
    }

    public void setJfirst(String jfirst) {
        this.jfirst = jfirst;
    }

    public String getJlast() {
        return jlast;
    }

    public void setJlast(String jlast) {
        this.jlast = jlast;
    }

    public int getJnumber() {
        return jnumber;
    }

    public void setJnumber(int jnumber) {
        this.jnumber = jnumber;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String get64baseImage() throws IOException {

        if(imagepath != "" && imagepath != null){

            MyByte mb = new MyByte();
            return mb.base64encode(this.getImagepath());

        }
        else return null;
    }

    public void setBase64(String base64){
        this.base64 = base64;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }


    
}
