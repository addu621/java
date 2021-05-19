package com.example.cars.services;

import com.example.cars.entities.*;
import com.example.cars.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.*;

@Service
public class PostService {
    @Autowired
    PostDetailsRepo postDetailsRepo;

    @Autowired
    Utility utility;

    @Autowired
    BuyRequestRepo buyRequestRepo;

    @Autowired
    InspectionDetailsRepo inspectionDetailsRepo;

    @Autowired
    ApprovedCarsRepo approvedCarsRepo;

    @Autowired
    private JavaMailSender javaMailSender;

    public PostDetails savePost(PostDetails postDetails, MultipartFile insurance,MultipartFile rc) throws IOException, MessagingException {
        postDetails.setApproved(false);
        postDetails.setSold(false);
        postDetails.setInsuranceCertificate(utility.compressBytes(insurance.getBytes()));
        postDetails.setRegistrationCertificate(utility.compressBytes(rc.getBytes()));
        postDetails.setDateOfPost(new Date());

        PostDetails savedPost=postDetailsRepo.save(postDetails);
        savedPost.setInsuranceCertificate(utility.decompressBytes(savedPost.getInsuranceCertificate()));
        savedPost.setRegistrationCertificate(utility.decompressBytes(savedPost.getRegistrationCertificate()));

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        String email = postDetails.getUserId().getUserEmail();

        String mailSubject = "Car Sell Request";
        String mailContent = "<div>" +
                "<h1 style=\"color: purple\">Car Sell Email</h1>" +
                "<div>" +
                "<p>" +
                "Hi "+ postDetails.getUserId().getUserName() +
                ",<br>" + "We have received your request for selling your car :- " + postDetails.getModelID().getCarId().getBrandId().getBrandName()
                + " " + postDetails.getModelID().getCarId().getCarName() + " " + postDetails.getModelID().getModelName() +".<br>" +
                "<br>" + "Shortly, Our nearest center will be contacting you for the car inspection and further arrangements"+
                "</p>" +
                "</div>" +
                "</div>";

        mimeMessageHelper.setFrom("studiocars2021@gmail.com","Cars Studio");
        mimeMessageHelper.setSubject(mailSubject);
        mimeMessageHelper.setText(mailContent,true);
        mimeMessageHelper.setTo(email);

        javaMailSender.send(mimeMessage);

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

    public List<Map> getBuyRequest() {

        List<BuyRequest> buyRequests= this.buyRequestRepo.findAll();

        List<Map> modifiedBuyRequests=new ArrayList<>();
        modelDetails model;
        for(int i=0;i<buyRequests.size();i++){
            Map<String,String> mp=new HashMap<>();
            model=buyRequests.get(i).getApprovedCarId().getPostID().getModelID();
            mp.put("buyer",buyRequests.get(i).getUserId().getUserName());
            mp.put("showRoom",buyRequests.get(i).getInspectionTeamId().getName());
            mp.put("carName",model.getCarId().getBrandId().getBrandName()+" "+model.getCarId().getCarName()+" "+model.getModelName());

            if(buyRequests.get(i).isDeclined())
                mp.put("status","Rejected");
            else if(buyRequests.get(i).getApproved())
                mp.put("status","Approved");
            else if(!buyRequests.get(i).getApproved() && !buyRequests.get(i).isDeclined())
                mp.put("status","Pending");

            mp.put("requestDate",buyRequests.get(i).getDateOfRequest().toString());
            modifiedBuyRequests.add(mp);
        }

        return modifiedBuyRequests;
    }


    public String rejectSellRequest(String postId) {
        try{


            PostDetails post=this.postDetailsRepo.findByPostId(Integer.parseInt(postId));

            post.setDeclined(true);


            this.postDetailsRepo.save(post);

            return "rejected";
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return "error";
        }

    }
}
