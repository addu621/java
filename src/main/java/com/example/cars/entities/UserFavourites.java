package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_favourites")
public class UserFavourites {

    public UserFavourites() {}
    public UserFavourites(Integer id, Integer userId, Integer carId) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer userId;

    @Column
    private Integer carId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
