package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "ApprovedCars")
public class ApprovedCars {

    public ApprovedCars(){}
    public ApprovedCars(Integer carId, PostDetails postID, modelDetails modelID, User sellerID, Integer price, Boolean isSold) {
        this.carId = carId;
        this.postID = postID;
        this.modelID = modelID;
        this.sellerID = sellerID;
        this.price = price;
        this.isSold = isSold;
    }

    @Id
    @Column
    private Integer carId;

    @JoinColumn
    @OneToOne
    private PostDetails postID;

    @JoinColumn
    @OneToOne
    private modelDetails modelID;

    @JoinColumn
    @OneToOne
    private User sellerID;

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

    public PostDetails getPostID() {
        return postID;
    }

    public void setPostID(PostDetails postID) {
        this.postID = postID;
    }

    public modelDetails getModelID() {
        return modelID;
    }

    public void setModelID(modelDetails modelID) {
        this.modelID = modelID;
    }

    public User getSellerID() {
        return sellerID;
    }

    public void setSellerID(User sellerID) {
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
