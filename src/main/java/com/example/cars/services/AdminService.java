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
import java.io.UnsupportedEncodingException;
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

    public String sendVerificationReq(String postId, String dealerId) throws MessagingException, UnsupportedEncodingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        PostDetails postDetails = postDetailsRepo.findByPostId(Integer.parseInt(postId));

        Dealer dealer = dealerRepo.findByDealerId(Integer.parseInt(dealerId));

        String mailSubject = "Car Inspection Request";
        String mailContent = "<div style=\"margin-left: 10%; \">" +
                "<h1 style=\"color: purple\">Verification Email</h1>" +
                "<div>" +
                "<p>" +
                "Hi "+dealer.getName() +
                ",<br>" + "You have recieved a customer Car-Inspection request.<br>" +
                "Find the details of Car and customer below - <br>" +
                "<br>" +
                "<br>" + "Location: "+postDetails.getLocation() +
                "<br>" + "Model Id: "+postDetails.getModelID() +
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

        javaMailSender.send(mimeMessage);
        return "Success";
    }
}
