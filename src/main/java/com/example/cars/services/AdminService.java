package com.example.cars.services;

import com.example.cars.entities.Admin;
import com.example.cars.entities.Dealer;
import com.example.cars.entities.PostDetails;
import com.example.cars.repositories.AdminRepo;
import com.example.cars.repositories.DealerRepo;
import com.example.cars.repositories.PostDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.ArrayList;

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
    private DealerRepo dealerRepo;

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

    public String sendVerificationReq(String postId, String dealerId) throws MessagingException, IOException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        PostDetails postDetails = postDetailsRepo.findByPostId(Integer.parseInt(postId));

        Dealer dealer = dealerRepo.findByDealerId(Integer.parseInt(dealerId));

        String mailSubject = "Car Inspection Request";
        String mailContent = "<div>" +
                "<h1 style=\"color: purple\">Inspection Email</h1>" +
                "<div>" +
                "<p>" +
                "Hi "+dealer.getName() +
                ",<br>" + "You have recieved a customer Car-Inspection request.<br>" +
                "Find the details of Car and customer below - <br>" +
                "<br>" +
                "<br>" + "Location: "+postDetails.getLocation() +
                "<br>" + "Brand Name: "+postDetails.getModelID().getCarId().getBrandId().getBrandName() +
                "<br>" + "Car Name: "+postDetails.getModelID().getCarId().getCarName() +
                "<br>" + "Model Name: "+postDetails.getModelID().getModelName() +
                "<br>" + "Model Year: "+postDetails.getModelYear() +
                "<br>" + "Model Kms-Run: "+postDetails.getKmsRun() +
                "</p>" +
                "</div>" +
                "<img src='cid:cars_logo' width=\"70%\">" +
                "</div>";
        mimeMessageHelper.setFrom("studiocars2021@gmail.com","Cars Studio");
        mimeMessageHelper.setSubject(mailSubject);
        mimeMessageHelper.setText(mailContent,true);
        mimeMessageHelper.setTo(dealer.getEmail());

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

        javaMailSender.send(mimeMessage);
        return "Post with postId: "+postDetails.getPostId()+" is assigned to dealer: "+dealer.getId() ;
    }
}
