package com.example.cars.controllers;

import com.example.cars.entities.BuyRequest;
import com.example.cars.entities.PostDetails;
import com.example.cars.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/save")
    public PostDetails savePost(@ModelAttribute PostDetails postDetails,@RequestParam("insurance") MultipartFile insurance,@RequestParam("rc")MultipartFile rc) throws IOException, MessagingException {
        return postService.savePost(postDetails,insurance,rc);
    }


    @GetMapping("/sellReq")
    public List sellRequests() {
        return postService.sellRequests();
    }

    @GetMapping("/buyReq")
    public List buyRequests() {
        return postService.buyRequests();
    }

    @GetMapping("/{postId}")
    public PostDetails getPostsById(@PathVariable("postId") String postId) {
        return postService.getPostsById(postId);
    }

    @PostMapping("/buyReq/save")
    public String saveBuyRequest(@RequestBody BuyRequest buyRequest){
        return postService.saveBuyRequest(buyRequest);
    }
}
