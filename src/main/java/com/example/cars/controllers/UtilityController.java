package com.example.cars.controllers;

import com.example.cars.services.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/utility")
public class UtilityController {

    @Autowired
    Utility utility;

    @GetMapping("/cityList")
    public List getAllCities(){
        return utility.getAllCities();
    }

}
