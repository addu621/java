package com.example.cars.controllers;

import com.example.cars.entities.Admin;
import com.example.cars.entities.PostDetails;
import com.example.cars.services.AdminService;
import com.example.cars.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PostService postService;

    @GetMapping("/login")
    public String loginAdmin(@RequestHeader String Authorization) {
        byte[] decodedBytes = Base64.getDecoder().decode(Authorization);
        String decodedString = new String(decodedBytes);
        String loginCredentials[]=decodedString.split(":");
        return adminService.loginUser(loginCredentials[0],loginCredentials[1]);
    }

    @GetMapping("/sellReq")
    public List sellRequests() {
        return postService.sellRequests();
    }

    @GetMapping("/getPost/{postId}")
    public PostDetails getPostsById(@PathVariable("postId") String postId) {
        return postService.getPostsById(postId);
    }

    @GetMapping("/sendForVerification")
    public String sendVerificationReq(@RequestBody Map<String,String> mp) throws MessagingException, UnsupportedEncodingException {
        return adminService.sendVerificationReq(mp.get("postId"),mp.get("dealerId"));
    }
}
