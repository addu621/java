package com.example.cars.repositories;

import com.example.cars.entities.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepo extends JpaRepository<Dealer,Integer> {
    Dealer findByDealerId(Integer dealerId);
}
