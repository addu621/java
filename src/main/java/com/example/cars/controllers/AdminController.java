package com.example.cars.controllers;

import com.example.cars.entities.Admin;
import com.example.cars.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ResponseEntity<?> loginAdmin(@RequestBody Admin admin) {
        UserDetails userDetails = adminService.loadUserByUsername(admin.getAdminEmail());

        return ResponseEntity.ok("Admin Email:" + admin.getAdminEmail());
    }
}
