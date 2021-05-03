package com.example.cars.controllers;
import java.io.ByteArrayOutputStream;

import com.example.cars.entities.ImageModel;
import com.example.cars.repositories.ImageRepo;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping(path = "image")
public class ImageUploadController {

    @Autowired
    ImageRepo imageRepository;

    @Autowired
    private SessionFactory sessionFactory;


    @PostMapping("/upload")

    public ImageModel uploadImage(@RequestBody MultipartFile file) throws IOException {


        System.out.println("Original Image Byte Size - " + file.getBytes().length);

        ImageModel img = new ImageModel();

        Blob pic=this.sessionFactory.getCurrentSession().getLobHelper().createBlob(file.getBytes());

        img.setName(file.getOriginalFilename());
        img.setType(file.getContentType());
        img.setPicByte(pic);

        ImageModel newImage=imageRepository.save(img);

        return newImage;

    }

    @GetMapping(path = { "/get/{imageName}" })

    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {

        final ImageModel retrievedImage = imageRepository.findByName(imageName);

        ImageModel img = new ImageModel(retrievedImage.getName(), retrievedImage.getType(),

                retrievedImage.getPicByte());

        return img;

    }

        // compress the image bytes before storing it in the database

    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();

        deflater.setInput(data);

        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {

            int count = deflater.deflate(buffer);

            outputStream.write(buffer, 0, count);

        }

        try {

            outputStream.close();

        } catch (IOException e) {

        }

        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();

    }


        // uncompress the image bytes before returning it to the angular application

    public static byte[] decompressBytes(byte[] data) {

        Inflater inflater = new Inflater();

        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        try {

            while (!inflater.finished()) {

                int count = inflater.inflate(buffer);

                outputStream.write(buffer, 0, count);

            }

            outputStream.close();

        } catch (IOException ioe) {

        } catch (DataFormatException e) {

        }

        return outputStream.toByteArray();

    }

}