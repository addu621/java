package com.example.cars.controllers;

import com.example.cars.entities.PostDetails;
import com.example.cars.entities.User;
import com.example.cars.entities.modelDetails;
import com.example.cars.repositories.PostDetailsRepo;
import com.example.cars.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/save")
    public PostDetails savePost(@ModelAttribute PostDetails postDetails,@RequestParam("insurance") MultipartFile insurance,@RequestParam("rc")MultipartFile rc) throws IOException {


        return postService.savePost(postDetails,insurance,rc);
    }




}
