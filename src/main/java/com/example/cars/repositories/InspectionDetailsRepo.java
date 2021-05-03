package com.example.cars.repositories;

import com.example.cars.entities.InspectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionDetailsRepo extends JpaRepository<InspectionDetails,Integer> {
}
