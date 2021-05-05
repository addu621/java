package com.example.cars.repositories;

import com.example.cars.entities.InspectionTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionTeamRepo extends JpaRepository<InspectionTeam,Integer> {
    InspectionTeam findByInspectionTeamId(Integer inspectionTeamId);
}
