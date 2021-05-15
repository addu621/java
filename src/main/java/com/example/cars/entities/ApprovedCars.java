package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "ApprovedCars")
public class ApprovedCars {

    public ApprovedCars(){}

    public ApprovedCars(Integer approvedCarId, PostDetails postID,Integer price, InspectionDetails inspectionDetails, Boolean isSold) {
        this.approvedCarId = approvedCarId;
        this.postID = postID;
        this.price = price;
        this.inspectionDetails = inspectionDetails;
        this.isSold = isSold;
    }

    @Id
    @Column
    private Integer approvedCarId;

    @JoinColumn(name = "postID")
    @OneToOne
    private PostDetails postID;

    @Column
    private Integer price;

    @JoinColumn(name = "inspectionDetails")
    @OneToOne
    private InspectionDetails inspectionDetails;

    @Column(columnDefinition = "boolean default false")
    private Boolean isSold;

    public Integer getApprovedCarId() {
        return approvedCarId;
    }

    public void setApprovedCarId(Integer carId) {
        this.approvedCarId = carId;
    }

    public PostDetails getPostID() {
        return postID;
    }

    public void setPostID(PostDetails postID) {
        this.postID = postID;
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
