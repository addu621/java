package com.example.cars.controllers;

import com.example.cars.entities.InspectionDetails;
import com.example.cars.entities.PostDetails;
import com.example.cars.services.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/inspection")
@CrossOrigin("*")
public class InspectionTeamController {

    @Autowired
    InspectionService inspectionService;

    @PostMapping("/save")
    public InspectionDetails saveInspectionDetails(@ModelAttribute InspectionDetails inspectionDetails,
                                             @RequestParam("carpic1") MultipartFile carPic1,
                                             @RequestParam("carpic2") MultipartFile carPic2,
                                             @RequestParam("carpic3") MultipartFile carPic3,
                                             @RequestParam("carpic4") MultipartFile carPic4,
                                             @RequestParam("carpic5") MultipartFile carPic5) throws IOException, MessagingException {


        return inspectionService.saveInspectionDetails(inspectionDetails,carPic1,carPic2,carPic3,carPic4,carPic5);
    }

}
