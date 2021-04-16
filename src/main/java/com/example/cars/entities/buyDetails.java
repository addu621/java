package com.example.cars.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "buyDetails")
public class buyDetails {

    public buyDetails(Integer userId, Integer buyId, Integer postId, Date dateOfRequest, Boolean isApproved) {
        this.userId = userId;
        this.buyId = buyId;
        this.postId = postId;
        this.dateOfRequest = dateOfRequest;
        this.isApproved = isApproved;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer userId;

    @Column
    private Integer buyId;

    @Column
    private Integer postId;

    @Column
    private Date dateOfRequest;

    @Column
    private Boolean isApproved;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }
}
