package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_favourites")
public class UserFavourites {

    public UserFavourites() {}
    public UserFavourites(Integer id, String userId, ApprovedCars approvedCarId) {
        this.id = id;
        this.userId = userId;
        this.approvedCarId = approvedCarId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String userId;

    @JoinColumn
    @OneToOne
    private ApprovedCars approvedCarId;

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

    public ApprovedCars getApprovedCarId() {
        return approvedCarId;
    }

    public void setApprovedCarId(ApprovedCars carId) {
        this.approvedCarId = carId;
    }
}
