package com.example.cars.services;

import com.example.cars.entities.InspectionDetails;
import com.example.cars.entities.PostDetails;
import com.example.cars.repositories.InspectionDetailsRepo;
import com.example.cars.repositories.PostDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class InspectionService {
    @Autowired
    InspectionDetailsRepo inspectionDetailsRepo;

    @Autowired
    Utility utility;

    @Autowired
    PostDetailsRepo postDetailsRepo;

    public InspectionDetails saveInspectionDetails(InspectionDetails inspectionDetails, MultipartFile carPic1, MultipartFile carPic2, MultipartFile carPic3, MultipartFile carPic4, MultipartFile carPic5) throws IOException {

        inspectionDetails.setCarPic1(carPic1.getBytes());
        inspectionDetails.setCarPic2(carPic2.getBytes());
        inspectionDetails.setCarPic3(carPic3.getBytes());
        inspectionDetails.setCarPic4(carPic4.getBytes());
        inspectionDetails.setCarPic5(carPic5.getBytes());

        InspectionDetails savedInspectionDetails=inspectionDetailsRepo.save(inspectionDetails);

//        savedInspectionDetails.setCarPic1(utility.decompressBytes(savedInspectionDetails.getCarPic1()));
//        savedInspectionDetails.setCarPic2(utility.decompressBytes(savedInspectionDetails.getCarPic2()));
//        savedInspectionDetails.setCarPic3(utility.decompressBytes(savedInspectionDetails.getCarPic3()));
//        savedInspectionDetails.setCarPic4(utility.decompressBytes(savedInspectionDetails.getCarPic4()));
//        savedInspectionDetails.setCarPic5(utility.decompressBytes(savedInspectionDetails.getCarPic5()));

        PostDetails post=postDetailsRepo.findByPostId(inspectionDetails.getPostId());
        post.setInspectionDone(true);
        postDetailsRepo.save(post);
        return savedInspectionDetails;
    }
}
