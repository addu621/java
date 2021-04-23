package com.example.cars.services;

import com.example.cars.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//        if(userName.equals("adarsh")) {
//            return new User("adarsh","1234",new ArrayList<>());
//        }
//        else {
//            throw new UsernameNotFoundException("User not found!!!");
//        }
//    }

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        com.example.cars.entities.User user = userDao.findByUserName(userName);
//        if(user==null) {
//            throw new UsernameNotFoundException("User not found!!!");
//        }
//        return new User(user.getUserName(), user.getUserPassword(),new ArrayList<>());
//    }
//
//    public com.example.cars.entities.User save(com.example.cars.entities.User user) {
//        com.example.cars.entities.User newUser = new com.example.cars.entities.User();
//        newUser.setUserName(user.getUserName());
//        newUser.setUserPassword(user.getUserPassword());
//        return userDao.save(newUser);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.example.cars.entities.User user = userRepo.findByUserEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(),
                new ArrayList<>());
    }


}
