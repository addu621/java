package com.example.cars.repositories;

import com.example.cars.entities.BuyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BuyRequestRepo extends JpaRepository<BuyRequest,Integer> {

    BuyRequest findByBuyId(Integer buyId);

    @Query(value="select * from buy_requests where user_id=?1 and approved_car_id=?2",nativeQuery = true)
    BuyRequest findBuyRequest(String userEmail, Integer approvedcarid);

    @Query(value="select * from buy_requests where user_id=?1 and is_approved=false and is_declined=false",nativeQuery = true)
    List<BuyRequest> findActiveRequests(String userEmail);

    @Query(value="select buy_id,date_of_request,is_approved,is_declined,inspection_team_id,approved_car_id,user_id from buy_requests",nativeQuery = true)
    List<Map> getAllBuyRequests();
}
