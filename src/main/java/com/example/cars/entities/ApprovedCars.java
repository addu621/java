package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "ApprovedCars")
public class ApprovedCars {


    public ApprovedCars(Integer carId, Integer postID, Integer modelID, Integer sellerID, Integer price, Boolean isSold) {
        this.carId = carId;
        this.postID = postID;
        this.modelID = modelID;
        this.sellerID = sellerID;
        this.price = price;
        this.isSold = isSold;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer carId;

    @Column
    private Integer postID;

    @Column
    private Integer modelID;

    @Column
    private Integer sellerID;

    @Column
    private Integer price;

    @Column(columnDefinition = "boolean default false")
    private Boolean isSold;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public Integer getModelID() {
        return modelID;
    }

    public void setModelID(Integer modelID) {
        this.modelID = modelID;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getSold() {
        return isSold;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }
}
