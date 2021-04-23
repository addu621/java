package com.example.cars.services;

import com.example.cars.entities.CarsBrand;
import com.example.cars.entities.User;
import com.example.cars.entities.cars;
import com.example.cars.entities.modelDetails;
import com.example.cars.repositories.CarsBrandRepo;
import com.example.cars.repositories.CarsRepo;
import com.example.cars.repositories.ModelDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Service
public class Utility {
    Logger logger = LoggerFactory.getLogger(Utility.class);
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ModelDetailsRepo modelDetailsRepo;

    @Autowired
    private CarsBrandRepo carsBrandRepo;

    @Autowired
    private CarsRepo carsRepo;


    @Async
    public void sendMail(User user, String token) throws UnsupportedEncodingException, MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        String mailSubject="Verification Email";
        String mailContent="<div style=\"margin-left: 10%; \">" +
                "<h1 style=\"color: purple\">Verification Email</h1>" +
                "<div>" +
                "<p>" +
                "Hi "+user.getUserName()+",<br>" +
                "Thanks for signing up at Cars-Studio, you are just One step away of your email verification.<br>" +
                "Please Enter the below OTP within <b>10 minutes</b>." +
                "</p>" +
                "<h3 style=\"color: red\">"+token+"</h3>" +
                "</div>" +
                "<img src='cid:cars_logo' width=\"70%\">" +
                "</div>";

        helper.setFrom("studiocars2021@gmail.com","Cars Studio");
        helper.setSubject(mailSubject);
        helper.setText(mailContent,true);
        helper.setTo(user.getUserEmail());

        ClassPathResource resource = new ClassPathResource("/static/images/cars_logo.png");
        helper.addInline("cars_logo",resource);

        javaMailSender.send(mimeMessage);

        logger.info("Mail Sent Successfully");
    }

    public String getToken(int size){
        String token="";

        for(int i=0;i<size;i++){
            token+=((int)(Math.random()*100))%10;
        }

        return token;
    }

    public List<CarsBrand> getAllBrands() {
        return carsBrandRepo.findAll();
    }

    public List<Map> getAllCarsByBrand(Integer brandId) {
         return carsRepo.getCarsByBrand(brandId);
    }

    public List<Map> getModelsByCarId(Integer car_id) {
        return modelDetailsRepo.getModelsByCarId(car_id);
    }
}
