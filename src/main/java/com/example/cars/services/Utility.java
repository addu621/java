package com.example.cars.services;

import com.example.cars.entities.*;
import com.example.cars.repositories.*;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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

    @Autowired
    private ApprovedCarsRepo approvedCarsRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private BuyRequestRepo buyRequestRepo;

    @Autowired
    private SoldCarRepo soldCarRepo;


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

    public byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();

        deflater.setInput(data);

        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {

            int count = deflater.deflate(buffer);

            outputStream.write(buffer, 0, count);

        }

        try {

            outputStream.close();

        } catch (IOException e) {

        }

        //System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();

    }


    // uncompress the image bytes before returning it to the angular application

    public byte[] decompressBytes(byte[] data) {

        Inflater inflater = new Inflater();

        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        byte[] buffer = new byte[1024];

        try {

            while (!inflater.finished()) {

                int count = inflater.inflate(buffer);

                outputStream.write(buffer, 0, count);

            }

            outputStream.close();

        } catch (IOException ioe) {

        } catch (DataFormatException e) {

        }

        return outputStream.toByteArray();

    }

    @Async
    public void sendEmailToShowRoom(BuyRequest buyRequest) throws UnsupportedEncodingException, MessagingException {

        User user=buyRequest.getUserId();
        PostDetails postDetails=buyRequest.getApprovedCarId().getPostID();
        InspectionTeam inspectionTeam=buyRequest.getInspectionTeamId();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        String mailSubject="Request for Buying a Car";
        String mailContent="<div style=\"margin-left: 2%; \">\n" +
                "\t<h1 style=\"color: purple\">Buy Car Request</h1>\n" +
                "\t<div>\n" +
                "\t\t<p>\n" +
                "\t\tHi "+inspectionTeam.getName()+" Team,<br>\n" +
                "\t\t<p>"+user.getUserName()+" is interested in buying "+postDetails.getModelID().getCarId().getBrandId().getBrandName()+" "+postDetails.getModelID().getCarId().getCarName()+" "+postDetails.getModelID().getModelName()+" Model (carId -"+postDetails.getModelID().getCarId().getCarId()+")</p>\n" +
                "\t\t<p>\n" +
                "\t\t\t<b><u>Contact Details</u></b>\n" +
                "\t\t\t<ul style=\"width: 200px\">\n" +
                "\t\t\t<li>\n" +
                "\t\t\t<div style=\"display: flex;margin-bottom: 10px\">\n" +
                "\t\t\t\t<div style=\"margin-right:10px\">Phone Number:</div>\n" +
                "\t\t\t\t<div>"+user.getPhoneNumber()+"</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t<div style=\"display: flex;margin-bottom: 10px\">\n" +
                "\t\t\t\t<div style=\"margin-right:10px\">Email:</div>\n" +
                "\t\t\t\t<div>"+user.getUserEmail()+"</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t<div style=\"display: flex;margin-bottom: 10px\">\n" +
                "\t\t\t\t<div style=\"margin-right:10px\">Address:</div>\n" +
                "\t\t\t\t<div>"+user.getAddress()+"</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t</li>\n" +
                "\t\t\t</ul>\n" +
                "\t\t</p>\n" +
                "\t\t</p>\n" +
                "\t\t<h4 style=\"color: red\">Please Click this link to update the result of this request <a href='http://localhost:4200/approveBuyReq?buyId="+buyRequest.getBuyId()+"&userName="+user.getUserName()+"&carName="+postDetails.getModelID().getCarId().getBrandId().getBrandName()+" "+postDetails.getModelID().getCarId().getCarName()+" "+postDetails.getModelID().getModelName()+"'>Link</a></h4>\n" +
                "\t\t<p>\n" +
                "\t\t\tFor any further query , please contact to the Cars Studio Team at <b>studiocars2021@gmail.com</b> \n" +
                "\t\t</p>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<img src='cid:cars_logo' width=\"70%\">\n" +
                "\t\n" +
                "</div>";


        helper.setFrom("studiocars2021@gmail.com","Cars Studio");
        helper.setSubject(mailSubject);
        helper.setText(mailContent,true);
        helper.setTo(inspectionTeam.getEmail());

        ClassPathResource resource = new ClassPathResource("/static/images/cars_logo.png");
        helper.addInline("cars_logo",resource);

        javaMailSender.send(mimeMessage);

        logger.info("Mail Sent Successfully");
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

    public List<cars> getCarsByCarType(String carType) { return carsRepo.findByCarType(carType);}

    public List<ApprovedCars> getApprovedCars() {
        return this.approvedCarsRepo.findAllApprovedCars();
    }

    public List getAllCities() {

        return cityRepo.findAll();

    }

    public String changeRequestStatus(String status, String buyId) {
        BuyRequest buyRequest=buyRequestRepo.findByBuyId(Integer.parseInt(buyId));
        ApprovedCars car=buyRequest.getApprovedCarId();
        SoldCars alreadySoldCar=soldCarRepo.findSoldCar(car.getApprovedCarId(),buyRequest.getUserId().getUserEmail());

        if(alreadySoldCar!=null || buyRequest.isDeclined()){
            return "Response, Already Submitted !";
        }

        if(status.equals("approve")){
            SoldCars soldCar = new SoldCars();
            soldCar.setBuyerId(buyRequest.getUserId().getUserEmail());
            soldCar.setApprovedCars(car);
            buyRequest.setApproved(true);
            car.setSold(true);
            soldCarRepo.save(soldCar);
            approvedCarsRepo.save(car);
            buyRequestRepo.save(buyRequest);
        }
        else{
            buyRequest.setDeclined(true);
            buyRequestRepo.save(buyRequest);
        }

        return "Response, Saved Successfully!";
    }
}
