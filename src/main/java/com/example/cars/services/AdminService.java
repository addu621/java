package com.example.cars.services;

import com.example.cars.entities.*;
import com.example.cars.repositories.AdminRepo;
import com.example.cars.repositories.InspectionDetailsRepo;
import com.example.cars.repositories.InspectionTeamRepo;
import com.example.cars.repositories.PostDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.ArrayList;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService{

    @Autowired
    private JavaMailSender javaMailSender;

    Logger logger = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PostDetailsRepo postDetailsRepo;

    @Autowired
    private InspectionTeamRepo inspectionTeamRepo;

    @Autowired
    private InspectionDetailsRepo inspectionDetailsRepo;

    @Autowired
    private Utility utility;

    public String loginUser(String email,String password){
        Admin admin = adminRepo.findByAdminEmail(email);



        if(admin!=null && admin.getAdminPassword().equals(password)){
            return "success";
        }

        return "denied";
    }

    public void createAdmins() {

        Admin adm1=new Admin("Dishant","dishant.vashistha@hashedin.com","abc123");
        Admin adm2=new Admin("Adarsh","adarsh.singh@hashedin.com","abc123");
        Admin adm3=new Admin("Vibhor","vibhor.nautiyal@hashedin.com","abc123");
        Admin adm4=new Admin("Mayank","mayank.sharma@hashedin.com","abc123");
        try {
            adminRepo.save(adm1);
        }catch(Exception exception){}
        try {
            adminRepo.save(adm2);
        }catch(Exception exception){}
        try {
            adminRepo.save(adm3);
        }catch(Exception exception){}
        try {
            adminRepo.save(adm4);
        }catch(Exception exception){}
        logger.info("All Admins Created Successfully");

    }

    public String sendVerificationReq(String postId, String inspectionTeamId) throws MessagingException, IOException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        PostDetails postDetails = postDetailsRepo.findByPostId(Integer.parseInt(postId));

        InspectionTeam inspectionTeam = inspectionTeamRepo.findByInspectionTeamId(Integer.parseInt(inspectionTeamId));

        String mailSubject = "Car Inspection Request";
        String mailContent = "<div>" +
                "<h1 style=\"color: purple\">Inspection Email</h1>" +
                "<div>" +
                "<p>" +
                "Hi "+ inspectionTeam.getName() +
                ",<br>" + "You have recieved a customer Car-Inspection request.<br>" +
                "Find the details of Car and customer below - <br>" +
                "<br>" +
                "<br>" + "Location: "+postDetails.getLocation() +
//                "<br>" + "Brand Name: "+postDetails.getModelID().getCarId().getBrandId().getBrandName() +
//                "<br>" + "Car Name: "+postDetails.getModelID().getCarId().getCarName() +
                "<br>" + "Model Id: "+postDetails.getModelID() +
                "<br>" + "Model Year: "+postDetails.getModelYear() +
                "<br>" + "Model Kms-Run: "+postDetails.getKmsRun() +
                "</p>" +
                "<a href = 'http://localhost:4200/inspection' >" + "Click here" + "</a>"  +
                "</div>" +
                "<img src='cid:cars_logo' width=\"70%\">" +
                "</div>";
        mimeMessageHelper.setFrom("studiocars2021@gmail.com","Cars Studio");
        mimeMessageHelper.setSubject(mailSubject);
        mimeMessageHelper.setText(mailContent,true);
        mimeMessageHelper.setTo(inspectionTeam.getEmail());
        byte[] registration_certificate = utility.decompressBytes(postDetails.getRegistrationCertificate());
        byte[] insurance_certificate = utility.decompressBytes(postDetails.getInsuranceCertificate());

        File rcFile = new File("/rcFile.jpg");
        File insuranceFile = new File("/insFile.jpg");

        OutputStream rcOs = new FileOutputStream(rcFile);
        rcOs.write(registration_certificate);
        rcOs.close();

        OutputStream insOs = new FileOutputStream(insuranceFile);
        insOs.write(insurance_certificate);
        insOs.close();

        mimeMessageHelper.addAttachment("Registration Certificate",rcFile);

        mimeMessageHelper.addAttachment("Insurance Certificate",insuranceFile);

        postDetails.setSentForInspection(true);
        postDetails.setInspectionTeamId(Integer.parseInt(inspectionTeamId));
        postDetailsRepo.save(postDetails);

        javaMailSender.send(mimeMessage);

        return inspectionTeam.getName();
    }

    public String sendVerificationReq2(String inspectionTeamId){

        InspectionTeam team = inspectionTeamRepo.findByInspectionTeamId(Integer.parseInt(inspectionTeamId));

        return team.getName();

    }

    public Map sendVerificationReq3(Integer postId) {

        PostDetails post = postDetailsRepo.findByPostId(postId);
        Map<String,Object> mp = new HashMap<>();

        InspectionTeam team = inspectionTeamRepo.findByInspectionTeamId(post.getInspectionTeamId());

        InspectionDetails details = inspectionDetailsRepo.findByPostId(post.getInspectionTeamId());

        mp.put("inspectionDetails", details);
        mp.put("inspectionTeamName", team.getName());
        return mp;
    }



    public String addInspectionTeam(InspectionTeam inspectionTeam) {
        try {
            inspectionTeam.setPendingRequests(0);
            inspectionTeam.setTotalRequests(0);
            inspectionTeamRepo.save(inspectionTeam);
            return "success";
        }catch (Exception ex){
            return "error";
        }
    }


}
