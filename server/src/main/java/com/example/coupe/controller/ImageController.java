package com.example.coupe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.coupe.Services.UploadService;

@RestController
public class ImageController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile){
    
        try {
			uploadService.saveImage(imageFile);
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("Error uploading image !!!");
		}

        return "Image uploaded successfully!";
    }

}
