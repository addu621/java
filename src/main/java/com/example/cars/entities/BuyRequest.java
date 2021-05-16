package com.example.cars.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "buyRequests")
public class BuyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer buyId;


    @JoinColumn(name = "userId")
    @ManyToOne
    private User userId;

    @JoinColumn(name = "postId")
    @OneToOne
    private PostDetails postId;

    @Column
    private Date dateOfRequest;

    @Column(columnDefinition = "boolean default false")
    private Boolean isApproved;

    @JoinColumn(name = "inspectionTeamId")
    @ManyToOne
    private InspectionTeam inspectionTeamId;

    public BuyRequest() {
    }

    public BuyRequest(Integer buyId, User userId, PostDetails postId, Date dateOfRequest, Boolean isApproved, InspectionTeam inspectionTeamId) {
        this.buyId = buyId;
        this.userId = userId;
        this.postId = postId;
        this.dateOfRequest = dateOfRequest;
        this.isApproved = isApproved;
        this.inspectionTeamId = inspectionTeamId;
    }

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

    public InspectionTeam getInspectionTeamId() {
        return inspectionTeamId;
    }

    public void setInspectionTeamId(InspectionTeam inspectionTeamId) {
        this.inspectionTeamId = inspectionTeamId;
    }

    @Override
    public String toString() {
        return "BuyRequest{" +
                "buyId=" + buyId +
                ", userId=" + userId +
                ", postId=" + postId +
                ", dateOfRequest=" + dateOfRequest +
                ", isApproved=" + isApproved +
                ", inspectionTeamId=" + inspectionTeamId +
                '}';
    }
}
