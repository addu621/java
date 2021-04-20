package com.example.cars.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "postDetails")
public class postDetails {

    public postDetails(User userId, Integer postId, Date dateOfPost, modelDetails modelID, Integer kmsRun, Integer modelYear, Boolean isApproved, Boolean isSold) {
        this.userId = userId;
        this.postId = postId;
        this.dateOfPost = dateOfPost;
        this.modelID = modelID;
        this.kmsRun = kmsRun;
        this.modelYear = modelYear;
        this.isApproved = isApproved;
        this.isSold = isSold;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer postId;

    @JoinColumn
    @ManyToOne
    private User userId;

    @Column
    private Date dateOfPost;

    @JoinColumn
    @ManyToOne
    private modelDetails modelID;

    @Column(nullable = false)
    private Integer kmsRun;

    @Column(nullable = false)
    private Integer modelYear;

    @Column(columnDefinition = "boolean default false")
    private Boolean isApproved;

    @Column(columnDefinition = "boolean default false")
    private Boolean isSold;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Date getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Date dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public modelDetails getModelID() {
        return modelID;
    }

    public void setModelID(modelDetails modelID) {
        this.modelID = modelID;
    }

    public Integer getKmsRun() {
        return kmsRun;
    }

    public void setKmsRun(Integer kmsRun) {
        this.kmsRun = kmsRun;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Boolean getSold() {
        return isSold;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }
}
