package com.example.cars.controllers;

import com.example.cars.entities.*;
import com.example.cars.services.UserService;
import com.example.cars.services.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    Utility utility;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
    //http://localhost:8080/user/save
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

    @GetMapping("/getModelDetails")
    public List<Map> getModelsByCarId(@RequestBody Integer car_id){
        return utility.getModelsByCarId(car_id);
    }
    @GetMapping("/getBrands")
    public List<CarsBrand> getAllCarBrands(){
        return utility.getAllBrands();
    }
    @GetMapping("/getCars")
    public List<Map> getAllCarsByBrand(@RequestBody Integer brandId){
        return utility.getAllCarsByBrand(brandId);
    }

    @GetMapping("/getCarType")
    public List<cars> getCarsByCarType(@RequestBody String carType) { return utility.getCarsByCarType(carType);}

    @PostMapping("/addFav")
    public String addToFav(@RequestBody UserFavourites userFavourites) {
        return userService.addFavourite(userFavourites);
    }

    @DeleteMapping("/removeFav")
    public String removeFromFav(@RequestBody Integer userFavourites) {
        return userService.removeFavourite(userFavourites);
    }

}
