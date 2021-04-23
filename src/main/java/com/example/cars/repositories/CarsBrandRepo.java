package com.example.cars.repositories;

import com.example.cars.entities.CarsBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsBrandRepo extends JpaRepository<CarsBrand,Integer> {



}
