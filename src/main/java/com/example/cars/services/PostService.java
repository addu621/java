package com.example.cars.services;

import com.example.cars.entities.PostDetails;
import com.example.cars.repositories.PostDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostDetailsRepo postDetailsRepo;

    @Autowired
    Utility utility;

    public PostDetails savePost(PostDetails postDetails, MultipartFile insurance,MultipartFile rc) throws IOException {
        postDetails.setApproved(false);
        postDetails.setSold(false);
        postDetails.setInsuranceCertificate(utility.compressBytes(insurance.getBytes()));
        postDetails.setRegistrationCertificate(utility.compressBytes(rc.getBytes()));
        postDetails.setDateOfPost(new Date());

        PostDetails savedPost=postDetailsRepo.save(postDetails);
        savedPost.setInsuranceCertificate(utility.decompressBytes(savedPost.getInsuranceCertificate()));
        savedPost.setRegistrationCertificate(utility.decompressBytes(savedPost.getRegistrationCertificate()));

        return savedPost;
    }

    public List sellRequests() {
        List request = postDetailsRepo.findAll();
        return request;
    }

    public List buyRequests() {
        List request = postDetailsRepo.findAll();
        return request;
    }

    public PostDetails getPostsById(String postId) {
        PostDetails postDetails = postDetailsRepo.findByPostId(Integer.parseInt(postId));
        return postDetails;

    }
}
