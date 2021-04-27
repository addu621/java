package com.example.cars.repositories;

import com.example.cars.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,String> {
    public Admin findByAdminEmail(String email);
}
