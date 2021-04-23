package com.example.cars.repositories;

import com.example.cars.entities.modelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ModelDetailsRepo extends JpaRepository<modelDetails,Integer> {

    public modelDetails findByModelId(Integer modelId);

    @Query(value = "select model_id,model_name from model_details where car_id=?1",nativeQuery = true)
    List<Map> getModelsByCarId(Integer car_id);
}
