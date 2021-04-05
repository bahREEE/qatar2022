package com.example.coupe.Utilities;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.example.coupe.entities.Joueur;

import java.awt.image.BufferedImage;


public class MyByte {
    
    public byte[] byteConversion(Joueur j) throws IOException {
        File fnew=new File(j.getImagepath());
        BufferedImage originalImage = ImageIO.read(fnew);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(originalImage, "PNG", baos );
        return baos.toByteArray();
    }

}
