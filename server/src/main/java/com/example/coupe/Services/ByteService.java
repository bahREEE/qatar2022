package com.example.coupe.Services;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.example.coupe.entities.Joueur;

import java.awt.image.BufferedImage;


@Service
public class ByteService {

    
    
    public void makeBytes(Joueur j) throws IOException {
	
        File fnew=new File(j.getImagepath());
        BufferedImage originalImage = ImageIO.read(fnew);;
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(originalImage, "PNG", baos );
        byte[] imageInByte=baos.toByteArray();
        
        j.setImageBytes(imageInByte);

    }

    public byte[] byteConversion(Joueur j) throws IOException {
        File fnew=new File(j.getImagepath());
        BufferedImage originalImage = ImageIO.read(fnew);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(originalImage, "PNG", baos );
        return baos.toByteArray();

    }

}
