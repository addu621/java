package com.example.cars.services;

import com.example.cars.entities.ApprovedCars;
import com.example.cars.entities.BuyRequest;
import com.example.cars.entities.InspectionDetails;
import com.example.cars.entities.PostDetails;
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

    public BuyRequest getBuyRequest(String reqId) {
        return buyRequestRepo.findByBuyId(Integer.parseInt(reqId));
    }


    public String changeApproveStatus(String postId, String status) {
        try{
            if(status.equals("No")) {
                this.postDetailsRepo.deleteById(Integer.parseInt(postId));
                return "rejected";
            }
            PostDetails post=this.postDetailsRepo.findByPostId(Integer.parseInt(postId));

            post.setApproved(true);

            ApprovedCars approveCar=new ApprovedCars();

            InspectionDetails inspectionDetails=inspectionDetailsRepo.findByPostId(Integer.parseInt(postId));
            approveCar.setApprovedCarId(Integer.parseInt(postId));
            approveCar.setPostID(post);
            approveCar.setSold(false);
            approveCar.setInspectionDetails(inspectionDetails);
            approveCar.setPrice(Integer.parseInt(inspectionDetails.getPrice()));

            this.postDetailsRepo.save(post);
            this.approvedCarsRepo.save(approveCar);

            return "approved";
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return "error";
        }

    }
}
