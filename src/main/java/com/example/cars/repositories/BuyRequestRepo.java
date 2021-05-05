package com.example.cars.repositories;

import com.example.cars.entities.BuyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRequestRepo extends JpaRepository<BuyRequest,Integer> {

    BuyRequest findByBuyId(Integer buyId);

}
