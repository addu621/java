package com.example.cars.services;

import com.example.cars.entities.User;
import com.example.cars.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private Utility utility;
    @Autowired
    private UserRepo userRepo;

    public Map save(User user){
        String token= utility.getToken(6);
        user.setVerificationToken(token);
        user.setVerification_date(new Date());
        user.setVerified(false);
        System.out.println(user.toString());
        Map<String,Object> mp= new HashMap<String,Object>();
        try{
            User existingUser=userRepo.findByUserEmail(user.getUserEmail());
            if(existingUser!=null){
                throw new Exception("User with this Email Id already Exists!");
            }
            User savedUser=userRepo.save(user);
            mp.put("user",savedUser);
            mp.put("message","Please Verify your email");
            utility.sendMail(user, token);
        }
        catch (Exception ex){
            mp.put("message",ex.getMessage());
        }

        return mp;
    }

    public Map verify(String userEmail,String verificationToken){
        Long TOKEN_EXPIRE_TIME= Long.valueOf(600000);
        Map<String,Object> mp= new HashMap<String,Object>();
        try {
            User user = userRepo.findByUserEmail(userEmail);
            if (user != null) {
                Date d1= new Date();
                Date d2= user.getVerification_date();

                if(d1.getTime()-d2.getTime() > TOKEN_EXPIRE_TIME){
                    mp.put("message","Token Expired");
                }
                else{
                    if(verificationToken.equals(user.getVerificationToken())){
                        user.setVerified(true);
                        userRepo.save(user);
                        mp.put("message","User Verified Successfully");
                        mp.put("user",user);
                    }
                    else{
                        mp.put("message","Token is not correct");
                    }
                }

            } else {
                throw new Exception("User with this Email Id does not exists!");
            }
        }
        catch (Exception ex){
            mp.put("error",ex.getMessage());
        }

        return mp;
    }

    public String resendVerificationMail(String userEmail) throws UnsupportedEncodingException, MessagingException {

            User user = userRepo.findByUserEmail(userEmail);

            if (user != null) {

                String newToken= utility.getToken(6);

                user.setVerificationToken(newToken);
                user.setVerification_date(new Date());

                userRepo.save(user);

                utility.sendMail(user, newToken);

                return "Success";
            }


            return "User with this Email Id already Exists!";
    }

}
