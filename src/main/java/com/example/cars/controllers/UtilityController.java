package com.example.cars.controllers;

import com.example.cars.services.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
