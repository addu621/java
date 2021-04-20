package com.example.cars.repositories;

import com.example.cars.entities.User;
import com.example.cars.model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    public User findByUserEmail(String email);

    public UserDao findByUserName(String userName);
}
