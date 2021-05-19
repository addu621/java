package com.example.cars.controllers;

import com.example.cars.entities.*;
import com.example.cars.entities.BuyRequest;
import com.example.cars.services.AdminService;
import com.example.cars.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @PostMapping("/sendForInspection")
    public String sendVerificationReq(@RequestBody Map<String,String> mp) throws MessagingException, IOException {
        adminService.sendVerificationReqUser(mp.get("postId"),mp.get("inspectionTeamId"));
        return adminService.sendVerificationReq(mp.get("postId"),mp.get("inspectionTeamId"));
    }

    @GetMapping("/sendForInspection")
    public String sendVerificationReq2(@RequestParam String inspectionTeamId) {
        return adminService.sendVerificationReq2(inspectionTeamId);
    }

    @GetMapping("/getBuyRequest")
    public List<Map> getBuyRequest(){
        return this.postService.getBuyRequest();
    }

    @PatchMapping("/changeStatus")
    public String changeApproveStatus(@RequestBody Map<String,String> mp){
        return this.postService.rejectSellRequest(mp.get("postId"));
    }

    @PostMapping("/addInspectionTeam")
    public String addInspectionTeam(@RequestBody InspectionTeam inspectionTeam){
        return this.adminService.addInspectionTeam(inspectionTeam);
    }

    @GetMapping("/getInspectionDetailsByPostId")
    public Map sendVerificationReq3(@RequestParam Integer postId){
        return this.adminService.sendVerificationReq3(postId);
    }

    @GetMapping("/getInspectionCentre")
    public List<InspectionTeam> getInspectionCentre(@RequestParam String city){
        return this.adminService.getInspectionCentre(city);
    }


}
