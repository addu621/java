package com.example.cars.services;

import com.example.cars.entities.InspectionDetails;
import com.example.cars.repositories.InspectionDetailsRepo;
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

    public InspectionDetails saveInspectionDetails(InspectionDetails inspectionDetails, MultipartFile carPic1, MultipartFile carPic2, MultipartFile carPic3, MultipartFile carPic4, MultipartFile carPic5) throws IOException {

        inspectionDetails.setCarPic1(utility.compressBytes(carPic1.getBytes()));
        inspectionDetails.setCarPic1(utility.compressBytes(carPic2.getBytes()));
        inspectionDetails.setCarPic1(utility.compressBytes(carPic3.getBytes()));
        inspectionDetails.setCarPic1(utility.compressBytes(carPic4.getBytes()));
        inspectionDetails.setCarPic1(utility.compressBytes(carPic5.getBytes()));

        InspectionDetails savedInspectionDetails=inspectionDetailsRepo.save(inspectionDetails);

        savedInspectionDetails.setCarPic1(utility.decompressBytes(savedInspectionDetails.getCarPic1()));
        savedInspectionDetails.setCarPic1(utility.decompressBytes(savedInspectionDetails.getCarPic2()));
        savedInspectionDetails.setCarPic1(utility.decompressBytes(savedInspectionDetails.getCarPic3()));
        savedInspectionDetails.setCarPic1(utility.decompressBytes(savedInspectionDetails.getCarPic4()));
        savedInspectionDetails.setCarPic1(utility.decompressBytes(savedInspectionDetails.getCarPic5()));

        return savedInspectionDetails;
    }
}
