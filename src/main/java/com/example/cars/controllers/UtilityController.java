package com.example.cars.controllers;

import com.example.cars.services.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/utility")
@CrossOrigin("*")
public class UtilityController {

    @Autowired
    Utility utility;



    @GetMapping("/cityList")
    public List getAllCities(){
        return utility.getAllCities();
    }

    @PatchMapping("/changeRequestStatus")
    public String changeRequestStatus(@RequestBody Map<String,String> mp){
        return utility.changeRequestStatus(mp.get("status"),mp.get("buyId"));
    }

    @GetMapping("/forgetPassword")
    public String generateNewPassword(@RequestParam String userEmail){
        return "JBLASAD";
    }

    @PostMapping("/customize")
    public String sendCustomizeRequest(@RequestBody Map<String,String> request) throws MessagingException, UnsupportedEncodingException {
        utility.sendCustomizeRequest(request);
        return utility.sendCustomizeRequestUser(request);
    }

    @PostMapping("/contactus")
    public String contact(@RequestBody Map<String ,String> payload) throws MessagingException, UnsupportedEncodingException {
        return utility.contact(payload);
    }
}
