package com.example.cars.repositories;

import com.example.cars.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    public User findByUserEmail(String email);
}
