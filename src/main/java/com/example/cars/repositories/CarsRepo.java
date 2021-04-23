package com.example.cars.repositories;

import com.example.cars.entities.cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CarsRepo extends JpaRepository<cars,Integer> {
    @Query(value = "select car_id,car_name from cars where brand_id=?1",nativeQuery = true)
    List<Map> getCarsByBrand(Integer brandId);
}
