package com.example.coupe.entities;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.coupe.Utilities.MyByte;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "JoueurTBL")
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long joueurId;

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

    @Column(name = "base64image", nullable = false)
    private String base64;

    @ManyToOne
    @JoinColumn(name = "equipeId")
    private Equipe equipe;

    public Joueur(Long id, String jfirst, String jlast, int jnumber, String imagepath, byte[] imageBytes, String base64, Equipe equipe) {
        this.joueurId = id;
        this.jfirst = jfirst;
        this.jlast = jlast;
        this.jnumber = jnumber;
        this.imagepath = imagepath;
        this.imageBytes = imageBytes;
        this.base64 = base64;
        this.equipe = equipe;
    }

    public Long getJoueurId(){
        return joueurId;
    }

    public void setJoueurId(Long id){
        this.joueurId = id;
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

    public byte[] getImageBytes() throws IOException {
        if(imagepath != "" && imagepath != null){
            MyByte mb = new MyByte();
            return mb.byteConversion(this.getImagepath());
        }
        else return null;
    }

    public String get64baseImage() throws IOException {
        if(imagepath != "" && imagepath != null){
            MyByte mb = new MyByte();
            return mb.base64encode(this.getImagepath());
        }
        else return null;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
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
