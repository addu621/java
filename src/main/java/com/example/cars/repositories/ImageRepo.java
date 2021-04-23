package com.example.cars.repositories;

import com.example.cars.entities.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepo extends JpaRepository<ImageModel, Long> {

    ImageModel findByName(String name);

}

