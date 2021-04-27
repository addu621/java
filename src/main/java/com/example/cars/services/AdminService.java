package com.example.cars.services;

import com.example.cars.entities.Admin;
import com.example.cars.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepo.findByAdminEmail(email);
        if(admin==null) {
            throw new UsernameNotFoundException("Admin not found with email/username: " + email);
        }
        return new org.springframework.security.core.userdetails.User(admin.getAdminEmail(),admin.getAdminPassword(),
                new ArrayList<>());
    }
}
