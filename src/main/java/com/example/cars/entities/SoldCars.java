package com.example.cars.entities;

import javax.persistence.*;

@Entity
public class SoldCars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer soldCarId;

    @JoinColumn(name = "approvedCar")
    @OneToOne
    ApprovedCars approvedCar;

    @Column
    String buyerId;

    public Integer getSoldCarId() {
        return soldCarId;
    }

    public void setSoldCarId(Integer soldCarId) {
        this.soldCarId = soldCarId;
    }

    public ApprovedCars getApprovedCar() {
        return approvedCar;
    }

    public void setApprovedCars(ApprovedCars approvedCar) {
        this.approvedCar = approvedCar;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
