package com.example.cars.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "buyDetails")
public class BuyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer buyId;


    @Column
    private User userId;

    @Column
    private PostDetails postId;

    @Column
    private Date dateOfRequest;

    @Column
    private Boolean isApproved;

    @Column
    private String location;

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public PostDetails getPostId() {
        return postId;
    }

    public void setPostId(PostDetails postId) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
