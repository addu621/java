package com.example.cars.controllers;

import com.example.cars.entities.User;
import com.example.cars.model.JwtRequest;
import com.example.cars.jwtHelper.JwtUtil;
import com.example.cars.model.JwtResponse;
import com.example.cars.model.UserDto;
import com.example.cars.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
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

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String userName, String passWord) throws Exception {
        Objects.requireNonNull(userName);
        Objects.requireNonNull(passWord);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, passWord));
        }catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
        return ResponseEntity.ok(customUserDetailsService.save(user));
    }
}
