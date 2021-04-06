package com.example.coupe.Utilities;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;


public class MyByte {
    
    public byte[] byteConversion(String path) throws IOException {
        File fnew=new File(path);
        BufferedImage originalImage = ImageIO.read(fnew);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(originalImage, "PNG", baos );
        return baos.toByteArray();
    }

    public String base64encode(String path) throws IOException{
        byte[] data = this.byteConversion(path);
        return Base64.getEncoder().encodeToString(data);
    }

}
