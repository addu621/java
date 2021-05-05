package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "ApprovedCars")
public class ApprovedCars {

    public ApprovedCars(){}

    public ApprovedCars(Integer approvedCarId, PostDetails postID, modelDetails modelID, User sellerID, Integer price, InspectionDetails inspectionDetails, Boolean isSold) {
        this.approvedCarId = approvedCarId;
        this.postID = postID;
        this.modelID = modelID;
        this.sellerID = sellerID;
        this.price = price;
        this.inspectionDetails = inspectionDetails;
        this.isSold = isSold;
    }

    @Id
    @Column
    private Integer approvedCarId;

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

    @JoinColumn
    @OneToOne
    private InspectionDetails inspectionDetails;

    @Column(columnDefinition = "boolean default false")
    private Boolean isSold;

    public Integer getCarId() {
        return approvedCarId;
    }

    public void setCarId(Integer carId) {
        this.approvedCarId = carId;
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

    public InspectionDetails getInspectionDetails() {
        return inspectionDetails;
    }

    public void setInspectionDetails(InspectionDetails inspectionDetails) {
        this.inspectionDetails = inspectionDetails;
    }
}
