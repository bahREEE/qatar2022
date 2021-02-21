package com.example.coupe.entities;

import java.time.Instant;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "JoueurTBL")
public class Joueur extends User {

    @Column(name = "jfirst", nullable = false)
    private String jfirst;

    @Column(name = "jlast", nullable = false)
    private String jlast;

    @Column(name = "jnumber", nullable = false)
    private int jnumber;

    // @JsonIgnore
    @Column(name = "imagepath", nullable = false)
    private String imagepath;

    @Column(name = "imageBytes", nullable = true)
    private byte[] imageBytes;

    @ManyToOne
    @JoinColumn(name = "equipeId")
    private Equipe equipe;

    public Joueur(Long userId, String username, String password, String email, Instant creationDate, Boolean activated,
            Collection<MyRole> roles) {
        super(userId, username, password, email, creationDate, activated, roles);
    }

    public Joueur() {
    }

    public Joueur(Long userId, String username, String password, String email, Instant creationDate, Boolean activated,
            Collection<MyRole> roles, String jfirst, String jlast, int jnumber, String imagepath, byte[] imageBytes,
            Equipe equipe) {
        super(userId, username, password, email, creationDate, activated, roles);
        this.jfirst = jfirst;
        this.jlast = jlast;
        this.jnumber = jnumber;
        this.imagepath = imagepath;
        this.imageBytes = imageBytes;
        this.equipe = equipe;
    }

    public Joueur(String jfirst, String jlast, int jnumber, String imagepath, byte[] imageBytes, Equipe equipe) {
        this.jfirst = jfirst;
        this.jlast = jlast;
        this.jnumber = jnumber;
        this.imagepath = imagepath;
        this.imageBytes = imageBytes;
        this.equipe = equipe;
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

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }


    

}
