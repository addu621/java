package com.example.cars.services;

import com.example.cars.entities.ApprovedCars;
import com.example.cars.entities.InspectionDetails;
import com.example.cars.entities.PostDetails;
import com.example.cars.repositories.ApprovedCarsRepo;
import com.example.cars.repositories.InspectionDetailsRepo;
import com.example.cars.repositories.PostDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;

@Service
public class InspectionService {
    @Autowired
    InspectionDetailsRepo inspectionDetailsRepo;

    @Autowired
    Utility utility;

    @Autowired
    PostDetailsRepo postDetailsRepo;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ApprovedCarsRepo approvedCarsRepo;

    @Async
    public InspectionDetails saveInspectionDetails(InspectionDetails inspectionDetails, MultipartFile carPic1, MultipartFile carPic2, MultipartFile carPic3, MultipartFile carPic4, MultipartFile carPic5) throws IOException, MessagingException {

        inspectionDetails.setCarPic1(carPic1.getBytes());
        inspectionDetails.setCarPic2(carPic2.getBytes());
        inspectionDetails.setCarPic3(carPic3.getBytes());
        inspectionDetails.setCarPic4(carPic4.getBytes());
        inspectionDetails.setCarPic5(carPic5.getBytes());

        InspectionDetails savedInspectionDetails=inspectionDetailsRepo.save(inspectionDetails);

        PostDetails post=postDetailsRepo.findByPostId(inspectionDetails.getPostId());
        post.setInspectionDone(true);

        if(inspectionDetails.getIsReadyForSale().equals("Yes"))
            post.setApproved(true);
        else
            post.setDeclined(true);

        ApprovedCars approveCar=new ApprovedCars();

        approveCar.setApprovedCarId(post.getPostId());
        approveCar.setPostID(post);
        approveCar.setSold(false);
        approveCar.setInspectionDetails(inspectionDetails);
        approveCar.setPrice(Integer.parseInt(inspectionDetails.getPrice()));
        approvedCarsRepo.save(approveCar);

        postDetailsRepo.save(post);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        String email = post.getUserId().getUserEmail();
        Date date = new Date();
        String mailSubject = "Car Inspection Confirmation";
        String mailContent = "<div>" +
                "<h1 style=\"color: purple\">Car Inspection Report: Completed</h1>" +
                "<div>" +
                "<p>" +
                "Hi "+ post.getUserId().getUserName() +
                ",<br>" + "We're glad to let you know that the car inspection is done and also we thank you for making your deal with us!!!" +
                "<br>" + "You can find the details of the deal below :-"+
                "<br>" + "<b><u>Deal Details</u></b>"+
                "<ul style=\"width: 200px\">" +
                "<li>" +
                "<div style=\"display: flex;margin-bottom: 10px\">" +
                "<div style=\"margin-right:10px\">Car Name:</div>" +
                "<div>"+post.getModelID().getCarId().getBrandId().getBrandName() + " " + post.getModelID().getCarId().getCarName() + " " + post.getModelID().getModelName() +"</div>" +
                "</div>" +
                "</li>" +
                "<li>" +
                "<div style=\"display: flex;margin-bottom: 10px\">" +
                "<div style=\"margin-right:10px\">Date of deal:</div>" +
                "<div>"+ date +"</div>" +
                "</div>" +
                "</li>" +
                "<li>" +
                "<div style=\"display: flex;margin-bottom: 10px\">" +
                "<div style=\"margin-right:10px\">Deal Price:</div>" +
                "<div>"+ inspectionDetails.getPrice() +"</div>" +
                "</div>" +
                "</li>" +
                "</ul>" +
                "</p>" +
                "</div>" +
                "<br>" + "We once again Thank you for trusting on us and we hope we can be helpful to you in future." +
                "<br>" + "Have a Great Day Ahead!!!" +
                "<br>" +
                "<br>" + "For any further query , please contact to the Cars Studio Team at <b>studiocars2021@gmail.com</b>" +
                "</div>";

        mimeMessageHelper.setFrom("studiocars2021@gmail.com","Cars Studio");
        mimeMessageHelper.setSubject(mailSubject);
        mimeMessageHelper.setText(mailContent,true);
        mimeMessageHelper.setTo(email);

        javaMailSender.send(mimeMessage);


        return savedInspectionDetails;
    }
}
