package com.example.cars.repositories;

import com.example.cars.entities.UserFavourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavRepo extends JpaRepository<UserFavourites, Integer> {
    public List<UserFavourites> findAllByUserId(String userId);
}
