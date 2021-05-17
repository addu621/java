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
