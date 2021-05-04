package com.example.cars.repositories;

import com.example.cars.entities.ApprovedCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovedCarsRepo extends JpaRepository<ApprovedCars,Integer> {
}
