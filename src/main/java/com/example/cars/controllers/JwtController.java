package com.example.cars.controllers;

import com.example.cars.entities.User;
import com.example.cars.model.JwtRequest;
import com.example.cars.jwtHelper.JwtUtil;
import com.example.cars.model.JwtResponse;
import com.example.cars.services.CustomUserDetailsService;
import com.example.cars.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin("*")
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(name="/hello", method = RequestMethod.POST)
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Hi");
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "User authorized";
    }

//    @RequestMapping(value = "/token", method = RequestMethod.POST)
//    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
//        System.out.println(jwtRequest);
//        try {
//            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
//
//        }
//        catch (UsernameNotFoundException e) {
//            e.printStackTrace();
//            throw new Exception("Bad Credentials");
//        }catch (BadCredentialsException e) {
//            e.printStackTrace();
//            throw new Exception("Bad Credentials");
//        }
//
//        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
//
//        String token = this.jwtUtil.generateToken(userDetails);
//        System.out.println("JWT "+token);
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Map generateAuthenticationToken(@RequestHeader String loginCredentials) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(loginCredentials);
        String decodedString = new String(decodedBytes);
        String userLoginCredentials[]=decodedString.split(":");
        try {
            authenticate(userLoginCredentials[0], userLoginCredentials[1]);

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(userLoginCredentials[0]);


            String token = jwtUtil.generateToken(userDetails);

            Map<String, String> mp = new HashMap<>();
            mp.put("token", token);
            mp.put("userEmail", userLoginCredentials[0]);

            return mp;
        }
        catch (Exception e)
        {
            Map<String, String> mp = new HashMap<>();
            mp.put("Error", "Invalid Credentials");
            return mp;
        }
    }

    private void authenticate(String username, String password) throws Exception {
//        Objects.requireNonNull(username);
//        Objects.requireNonNull(password);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
