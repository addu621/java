package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_favourites")
public class UserFavourites {

    public UserFavourites() {}
    public UserFavourites(Integer id, String userId, Integer carId) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String userId;

    @Column
    private Integer carId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
