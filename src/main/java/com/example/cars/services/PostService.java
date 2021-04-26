package com.example.cars.services;

import com.example.cars.entities.PostDetails;
import com.example.cars.repositories.PostDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class PostService {
    @Autowired
    PostDetailsRepo postDetailsRepo;

    @Autowired
    Utility utility;

    public PostDetails savePost(PostDetails postDetails, MultipartFile aadhar,MultipartFile rc) throws IOException {
        postDetails.setApproved(false);
        postDetails.setSold(false);
        postDetails.setAadharCard(utility.compressBytes(aadhar.getBytes()));
        postDetails.setRegistrationCertificate(utility.compressBytes(rc.getBytes()));
        postDetails.setDateOfPost(new Date());

        PostDetails savedPost=postDetailsRepo.save(postDetails);
        savedPost.setAadharCard(utility.decompressBytes(savedPost.getAadharCard()));
        savedPost.setRegistrationCertificate(utility.decompressBytes(savedPost.getRegistrationCertificate()));

        return savedPost;
    }
}
