package com.example.cars.repositories;

import com.example.cars.entities.ApprovedCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovedCarsRepo extends JpaRepository<ApprovedCars,Integer> {
    @Query(value = "select * from approved_cars where is_sold=false",nativeQuery = true)
    List<ApprovedCars> findAllApprovedCars();
}
