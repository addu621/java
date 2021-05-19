package com.example.cars.services;

import com.example.cars.entities.*;
import com.example.cars.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
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

    @Autowired
    private ApprovedCarsRepo approvedCarsRepo;

    @Autowired
    private SoldCarRepo soldCarRepo;

    @Autowired
    private UserRepo userRepo;

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

    @Async
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
                "<br>" + "Car : "+ postDetails.getModelID().getCarId().getBrandId().getBrandName()
                + " " + postDetails.getModelID().getCarId().getCarName() + " " + postDetails.getModelID().getModelName()  +
                "<br>" + "Model Year: "+postDetails.getModelYear() +
                "<br>" + "Model Kms-Run: "+postDetails.getKmsRun() +
                "</p>" +
                "<a href ='https://carstudio2-dot-hu18-groupa-angular.et.r.appspot.com/inspection/"+postId+"/"+inspectionTeamId+"' >" + "Click here" + "</a>"  +
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
        inspectionTeam.setPendingRequests(inspectionTeam.getPendingRequests()+1);
        inspectionTeam.setTotalRequests(inspectionTeam.getTotalRequests()+1);

        inspectionTeamRepo.save(inspectionTeam);
        postDetailsRepo.save(postDetails);

        javaMailSender.send(mimeMessage);

        return inspectionTeam.getName();
    }

    @Async
    public String sendVerificationReqUser(String postId, String inspectionTeamId) throws MessagingException, UnsupportedEncodingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        PostDetails postDetails = postDetailsRepo.findByPostId(Integer.parseInt(postId));

        InspectionTeam inspectionTeam = inspectionTeamRepo.findByInspectionTeamId(Integer.parseInt(inspectionTeamId));

        String mailSubject = "Update: Car sell request Approved";
        String mailContent = "<div>" +
                "<h1 style=\"color: purple\">Sell Request Approved!!! </h1>" +
                "<div>" +
                "<p>" +
                "Hi "+ postDetails.getUserId().getUserName() +
                ",<br>" + "Congratulations!!! We're glad to let you know that your request for selling your car :- " + postDetails.getModelID().getCarId().getBrandId().getBrandName()
                + " " + postDetails.getModelID().getCarId().getCarName() + " " + postDetails.getModelID().getModelName() + " has been approved by the administration team.<br>" +
                "<br>" +
                "<br>" + "And your request has been assigned to the center - " + inspectionTeam.getName() +
                "<br>" +
                "<br>" + " Soon you'll be receiving a call from our service center team for scheduling of the appointment for inspection and further arrangements"+
                "</p>" +
                "<img src='cid:cars_logo' width=\"70%\">" +
                "</div>";
        mimeMessageHelper.setFrom("studiocars2021@gmail.com","Cars Studio");
        mimeMessageHelper.setSubject(mailSubject);
        mimeMessageHelper.setText(mailContent,true);
        mimeMessageHelper.setTo(postDetails.getUserId().getUserEmail());

        javaMailSender.send(mimeMessage);

        return "Mail sent to the user - " + postDetails.getUserId().getUserName();
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


    public List<InspectionTeam> getInspectionCentre(String city) {

        return this.inspectionTeamRepo.findAllByLocation(city);
    }

    public List<Map> getAllApprovedCars(){

        List<ApprovedCars> approvedCarsList = approvedCarsRepo.findAllApprovedCars();
        List<Map> res = new ArrayList<>();

        for(int i=0;i<approvedCarsList.size();i++){

            Map<String,String> mp = new HashMap<>();

            mp.put("brand",approvedCarsList.get(i).getPostID().getModelID().getCarId().getBrandId().getBrandName());
            mp.put("name",approvedCarsList.get(i).getPostID().getModelID().getCarId().getCarName());
            mp.put("model",approvedCarsList.get(i).getPostID().getModelID().getModelName());
            mp.put("location",approvedCarsList.get(i).getPostID().getLocation());
            mp.put("modelYear",approvedCarsList.get(i).getPostID().getModelYear().toString());
            mp.put("inspectionCentre",approvedCarsList.get(i).getInspectionDetails().getInspectionTeam().getName());

            res.add(mp);

        }

        return res;
    }

    public List<Map> getAllSoldCars(){
        List<SoldCars> soldCarsList = soldCarRepo.findAll();
        List<Map> res = new ArrayList<>();

        for(int i=0;i<soldCarsList.size();i++){

            Map<String,String> mp = new HashMap<>();

            mp.put("brand",soldCarsList.get(i).getApprovedCar().getPostID().getModelID().getCarId().getBrandId().getBrandName());
            mp.put("name",soldCarsList.get(i).getApprovedCar().getPostID().getModelID().getCarId().getCarName());
            mp.put("model",soldCarsList.get(i).getApprovedCar().getPostID().getModelID().getModelName());
            mp.put("showroomName",soldCarsList.get(i).getApprovedCar().getInspectionDetails().getInspectionTeam().getName());
            mp.put("price",soldCarsList.get(i).getApprovedCar().getPrice().toString());

            User user =  userRepo.findByUserEmail(soldCarsList.get(i).getBuyerId());
            mp.put("buyerName",user.getUserName());

            res.add(mp);
        }

        return res;
    }

    public List<InspectionTeam> getInspectionTeams(){
        return this.inspectionTeamRepo.findAll();
    }
}
