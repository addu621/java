package com.example.cars.controllers;

import com.example.cars.entities.Admin;
import com.example.cars.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String loginAdmin(@RequestBody Admin admin) {
        return adminService.loginUser(admin.getAdminEmail(),admin.getAdminPassword());
    }
}
