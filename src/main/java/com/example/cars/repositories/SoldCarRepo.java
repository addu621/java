package com.example.cars.repositories;

import com.example.cars.entities.SoldCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoldCarRepo extends JpaRepository<SoldCars,Integer> {
    @Query(value = "select * from sold_cars where approved_car=?1 and buyer_id=?2",nativeQuery = true)
    public SoldCars findSoldCar(Integer approvedCardId,String buyerID);

    List<SoldCars> findAllByBuyerId(String userEmail);
}
