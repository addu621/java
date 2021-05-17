package com.example.cars.repositories;

import com.example.cars.entities.UserFavourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserFavRepo extends JpaRepository<UserFavourites, Integer> {
    public List<UserFavourites> findAllByUserId(String userId);

    @Modifying
    @Transactional
    @Query(value = "delete from user_favourites where user_id=?1 and approved_car_id=?2", nativeQuery = true)
    public void deleteByUserIdApprovedId(String userId, Integer approvedCarId);

    @Query(value = "select count(*) from user_favourites where user_id=?1 and approved_car_id=?2", nativeQuery = true)
    public Integer findAllByUserIdApprovedId(String userId, Integer approvedCarId);
}