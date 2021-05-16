package com.example.cars.services;

import com.example.cars.entities.*;
import com.example.cars.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.cars.entities.InspectionTeam;
import com.example.cars.entities.User;
import com.example.cars.entities.UserFavourites;
import com.example.cars.repositories.InspectionTeamRepo;
import com.example.cars.repositories.UserFavRepo;
import com.example.cars.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private Utility utility;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserFavRepo userFavRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private BuyRequestRepo buyRequestRepo;

    @Autowired
    private PostDetailsRepo postDetailsRepo;

    @Autowired
    private InspectionTeamRepo inspectionTeamRepo;

    public Map save(User user){
        String token= utility.getToken(6);
        user.setVerificationToken(token);
        user.setVerification_date(new Date());
        user.setVerified(false);
        System.out.println(user.toString());
        Map<String,Object> mp= new HashMap<String,Object>();
        try{
            User existingUser=userRepo.findByUserEmail(user.getUserEmail());
            if(existingUser!=null){
                throw new Exception("User with this Email Id already Exists!");
            }
            user.setUserPassword(bcryptEncoder.encode(user.getUserPassword()));
            System.out.println(user.getUserPassword());
            User savedUser=userRepo.save(user);
            mp.put("user",savedUser);
            mp.put("message","Please Verify your email");
            utility.sendMail(user, token);
        }
        catch (Exception ex){
            mp.put("message",ex.getMessage());
        }

        return mp;
    }

    public Map verify(String userEmail,String verificationToken){
        Long TOKEN_EXPIRE_TIME= Long.valueOf(600000);
        Map<String,Object> mp= new HashMap<String,Object>();
        try {
            User user = userRepo.findByUserEmail(userEmail);
            if (user != null) {
                Date d1= new Date();
                Date d2= user.getVerification_date();

                if(d1.getTime()-d2.getTime() > TOKEN_EXPIRE_TIME){
                    mp.put("message","Token Expired");
                }
                else{
                    if(verificationToken.equals(user.getVerificationToken())){
                        user.setVerified(true);
                        userRepo.save(user);
                        mp.put("message","User Verified Successfully");
                        mp.put("user",user);
                    }
                    else{
                        mp.put("message","Token is not correct");
                    }
                }

            } else {
                throw new Exception("User with this Email Id does not exists!");
            }
        }
        catch (Exception ex){
            mp.put("error",ex.getMessage());
        }

        return mp;
    }

    public String resendVerificationMail(String userEmail) throws UnsupportedEncodingException, MessagingException {

            User user = userRepo.findByUserEmail(userEmail);

            if (user != null) {

                String newToken= utility.getToken(6);

                user.setVerificationToken(newToken);
                user.setVerification_date(new Date());

                userRepo.save(user);

                utility.sendMail(user, newToken);

                return "Success";
            }


            return "User with this Email Id already Exists!";
    }

    public String addFavourite(UserFavourites userFavourites) {
        userFavRepo.save(userFavourites);
        return "Car Id: " + userFavourites.getApprovedCarId() + " is added to favourites of User Id:" + userFavourites.getUserId();
    }

    public String removeFavourite(Integer userFavourites) {
        userFavRepo.deleteById(userFavourites);
        return "User deleted";
    }

    public List<UserFavourites> getAllFavs(String userId) {
        List<UserFavourites> userFavs = userFavRepo.findAllByUserId(userId);
        return userFavs;
    }

    public String remFav(String userId, String carId) {
        List<UserFavourites> userFavouritesList = userFavRepo.findAll();
        for(UserFavourites userFavourites : userFavouritesList)
        {
            if(userFavourites.getUserId().toString().equals(userId))
            {
             if(userFavourites.getApprovedCarId().toString().equals(carId))
             {
                 userFavRepo.delete(userFavourites);
                 return "User Id: " + userFavourites.getUserId() + " hates Car " + userFavourites.getApprovedCarId();
             }
            }
        }
        return "No data exists with User id: " + userId + " and CarId: " + carId;
    }

    @Async
    public String sendCustomizeRequestUser(Map<String,String> request) throws MessagingException, UnsupportedEncodingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);


        String team = request.get("center");
        InspectionTeam inspectionTeam = inspectionTeamRepo.findByName(team);

        String mailSubject = "Car Customization Request";
        String mailContent = "<div>" +
                "<h1 style=\"color: purple\">Customization Email</h1>" +
                "<div>" +
                "<p>" +
                "Hi "+ request.get("name") +
                ",<br>" +
                "<br>" + "We have received your Car-Customization request for items :- " + request.get("requirements") +".<br>" +
                "<br>" +
                "<br>" + "Our team at center " + team + " will be contacting you for the further details and arrangements"+
                "</p>" +
                "Meanwhile, if you want to sell or buy a old car, then you can checkout our website, where we offer competitive rates :-" +
                "<br> <a href ='https://carstudio2-dot-hu18-groupa-angular.et.r.appspot.com'>" + "Click here" + "</a>" +
                "</div>" +
                "</div>";

        System.out.println(request.get("name"));
        System.out.println(request.get("email"));
        mimeMessageHelper.setFrom("studiocars2021@gmail.com","Cars Studio");
        mimeMessageHelper.setSubject(mailSubject);
        mimeMessageHelper.setText(mailContent,true);
        mimeMessageHelper.setTo(request.get("email"));

        javaMailSender.send(mimeMessage);

        return request.get("name");
    }

    @Async
    public String sendCustomizeRequest(Map<String,String> request) throws MessagingException, UnsupportedEncodingException {

        /*
        center: "Mumbai"
        city: "Mumbai"
        contactNo: "9387383838"
        email: "mayank.sharma@hashedin.com"
        name: "Mayank Sharma Chomu"
       	requirements: "Reflector Lights,Antennas,Jumper Cables"
        */

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        String team = request.get("center");
        InspectionTeam inspectionTeam = inspectionTeamRepo.findByName(team);

        String mailSubject = "Car Customization Request";
        String mailContent = "<div>" +
                "<h1 style=\"color: purple\">Customization Email</h1>" +
                "<div>" +
                "<p>" +
                "Hi "+ inspectionTeam.getName() +
                ",<br>" + "You have received a car-customization request.<br>" +
                "Find the details of Customizations and customer below - <br>" +
                "<br>" +
                "<br>" + "Customer Name: "+ request.get("name") +
                "<br>" + "Customer Contact No.: "+ request.get("contactNo") +
                "<br>" + "Customer email: "+ request.get("email") +
                "<br>" + "Requested features: "+ request.get("requirements") +
                "</p>" +
                "</div>" +
                "</div>";
        mimeMessageHelper.setFrom("studiocars2021@gmail.com","Cars Studio");
        mimeMessageHelper.setSubject(mailSubject);
        mimeMessageHelper.setText(mailContent,true);
        mimeMessageHelper.setTo(inspectionTeam.getEmail());

        javaMailSender.send(mimeMessage);
        return inspectionTeam.getName();
    }

    public User findUser(String userLoginCredential) {
        return userRepo.findByUserEmail(userLoginCredential);
    }


    public String saveBuyRequest(BuyRequest buyRequest) {
        buyRequest.setDateOfRequest(new Date());
        buyRequest.setApproved(false);
        try {
            buyRequestRepo.save(buyRequest);
            utility.sendEmailToShowRoom(buyRequest);
            return "Success";
        }
        catch(Exception ex){
            return ex.getMessage();
//            return "Server Error, Request Not Accepted";
        }
    }



}
