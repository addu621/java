package com.example.cars.controllers;

import com.example.cars.entities.Admin;
import com.example.cars.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String loginAdmin(@RequestHeader String Authorization) {
        byte[] decodedBytes = Base64.getDecoder().decode(Authorization);
        String decodedString = new String(decodedBytes);
        String loginCredentials[]=decodedString.split(":");
        return adminService.loginUser(loginCredentials[0],loginCredentials[1]);
    }
}
