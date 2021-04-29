package com.example.cars.repositories;

import com.example.cars.entities.UserFavourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavRepo extends JpaRepository<UserFavourites, Integer> {

}
