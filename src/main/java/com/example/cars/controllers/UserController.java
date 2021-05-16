package com.example.cars.controllers;

import com.example.cars.entities.*;
import com.example.cars.services.UserService;
import com.example.cars.services.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/save")
    public Map signUp(@RequestBody User user){
            return userService.save(user);
    }

    @PatchMapping("/verify")
    public Map verify(@RequestBody Map<String,String> mp){
        return userService.verify(mp.get("userEmail"),mp.get("verification_token"));
    }

    @GetMapping("/resendVerificationMail")
    public String resendVerificationMail(@RequestParam String userEmail) throws UnsupportedEncodingException, MessagingException {
        return userService.resendVerificationMail(userEmail);
    }

    @GetMapping("/getModelDetails")
    public List<Map> getModelsByCarId(@RequestParam Integer car_id){
        return utility.getModelsByCarId(car_id);
    }

    @GetMapping("/getBrands")
    public List<CarsBrand> getAllCarBrands(){
        return utility.getAllBrands();
    }

    @GetMapping("/getCars")
    public List<Map> getAllCarsByBrand(@RequestParam Integer brandId){
        return utility.getAllCarsByBrand(brandId);
    }

    @GetMapping("/getCarType")
    public List<cars> getCarsByCarType(@RequestBody String carType) { return utility.getCarsByCarType(carType);}

    @PostMapping("/addFav")
    public String addToFav(@ModelAttribute UserFavourites userFavourites) {
        return userService.addFavourite(userFavourites);
    }

    @DeleteMapping("/removeFav/{id}")
    public String removeFromFav(@PathVariable Integer id) {
        return userService.removeFavourite(id);
    }

    @GetMapping("/getFavs")
    public List<UserFavourites> getAllFavs(@RequestBody String userId) { return userService.getAllFavs(userId); }

    @GetMapping("/customize")
    public String sendCustomizeRequest(@RequestBody Map<String,String> request) throws MessagingException, UnsupportedEncodingException {
        userService.sendCustomizeRequestUser(request);
        return userService.sendCustomizeRequest(request);
    }
    @GetMapping("/getApprovedCars")
    public List<ApprovedCars> getApprovedCars(){
        return this.utility.getApprovedCars();
    }

//    @PostMapping("/buyReq/save")
//    public String saveBuyRequest(@RequestBody Map<String,String> buyMap){
//        //System.out.println(buyRequest.toString());
//        return this.userService.saveBuyRequest(buyMap);
//    }


    @PostMapping("/buyReq/save")
    public String saveBuyRequest(@ModelAttribute BuyRequest buyRequest){
        return this.userService.saveBuyRequest(buyRequest);
    }




}
