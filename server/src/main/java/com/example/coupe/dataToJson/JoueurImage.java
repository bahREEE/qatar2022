package com.example.coupe.dataToJson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.example.coupe.entities.Joueur;
import java.awt.image.BufferedImage;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class JoueurImage {

    private Joueur joueur;
    private byte[] imageBytes;

    public JoueurImage(Joueur j) throws IOException {
        this.setJoueur(j);
        File fnew=new File(j.getImagepath());
        BufferedImage originalImage=ImageIO.read(fnew);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(originalImage, "PNG", baos );
        byte[] imageInByte=baos.toByteArray();
        this.setimageBytes(imageInByte);
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public byte[] getimageBytes() {
        return imageBytes;
    }

    public void setimageBytes(byte[] pathImageJoueur) {
        this.imageBytes = pathImageJoueur;
    }




}
