package com.example.cars.controllers;

import com.example.cars.entities.User;
import com.example.cars.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public Map signUp(@RequestBody User user){
            return userService.save(user);
    }

    @GetMapping("/verify")
    public Map verify(@RequestBody Map<String,String> mp){
        return userService.verify(mp.get("userEmail"),mp.get("verification_token"));
    }

    @GetMapping("/resendVerificationMail")
    public String resendVerificationMail(@RequestParam String userEmail) throws UnsupportedEncodingException, MessagingException {
        return userService.resendVerificationMail(userEmail);
    }

}
