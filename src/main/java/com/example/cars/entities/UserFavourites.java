package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_favourites")
public class UserFavourites {

    public UserFavourites() {}
    public UserFavourites(Integer id, String userId, ApprovedCars arrprovedCarId) {
        this.id = id;
        this.userId = userId;
        this.arrprovedCarId = arrprovedCarId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String userId;

    @JoinColumn
    @OneToOne
    private ApprovedCars arrprovedCarId;

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

    public ApprovedCars getCarId() {
        return arrprovedCarId;
    }

    public void setCarId(ApprovedCars carId) {
        this.arrprovedCarId = carId;
    }
}
