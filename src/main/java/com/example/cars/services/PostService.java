package com.example.cars.services;

import com.example.cars.entities.BuyRequest;
import com.example.cars.entities.PostDetails;
import com.example.cars.repositories.BuyRequestRepo;
import com.example.cars.repositories.PostDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    @Autowired
    PostDetailsRepo postDetailsRepo;

    @Autowired
    Utility utility;

    @Autowired
    BuyRequestRepo buyRequestRepo;

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
        List request = postDetailsRepo.findAllUnApprovedPosts();
        return request;
    }

    public List buyRequests() {
        List request = postDetailsRepo.findAll();
        return request;
    }

    public PostDetails getPostsById(String postId) {
        PostDetails postDetails = postDetailsRepo.findByPostId(Integer.parseInt(postId));
        postDetails.setInsuranceCertificate(utility.decompressBytes(postDetails.getInsuranceCertificate()));
        postDetails.setRegistrationCertificate(utility.decompressBytes(postDetails.getRegistrationCertificate()));
        return postDetails;

    }

    public String saveBuyRequest(BuyRequest buyRequest) {
        String result="success";
        try{
            buyRequestRepo.save(buyRequest);
        }catch (Exception ex){
            result="error";
        }

        return result;
    }

    public BuyRequest getBuyRequest(String reqId) {
        return buyRequestRepo.findByBuyId(Integer.parseInt(reqId));
    }


    public String changeApproveStatus(String postId, String status) {
        try{
            if(status.equals("false")) {
                this.postDetailsRepo.deleteById(Integer.parseInt(postId));
                return "rejected";
            }
            PostDetails post=this.postDetailsRepo.findByPostId(Integer.parseInt(postId));

            post.setApproved(Boolean.parseBoolean(status));

            this.postDetailsRepo.save(post);

                return "approved";
        }
        catch (Exception ex){
            return "error";
        }

    }
}
