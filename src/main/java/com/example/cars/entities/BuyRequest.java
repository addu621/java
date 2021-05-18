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

    @JoinColumn(name = "approvedCarId")
    @OneToOne
    private ApprovedCars approvedCarId;

    @Column
    private Date dateOfRequest;

    @Column(columnDefinition = "boolean default false")
    private Boolean isApproved;

    @JoinColumn(name = "inspectionTeamId")
    @ManyToOne
    private InspectionTeam inspectionTeamId;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeclined;

    public BuyRequest() {
    }

    public BuyRequest(Integer buyId, User userId, ApprovedCars approvedCarId, Date dateOfRequest, Boolean isApproved, InspectionTeam inspectionTeamId) {
        this.buyId = buyId;
        this.userId = userId;
        this.approvedCarId = approvedCarId;
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

    public ApprovedCars getApprovedCarId() {
        return approvedCarId;
    }

    public void setApprovedCarId(ApprovedCars approvedCarId) {
        this.approvedCarId = approvedCarId;
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

    public boolean isDeclined() {
        return isDeclined;
    }

    public void setDeclined(boolean declined) {
        isDeclined = declined;
    }

    @Override
    public String toString() {
        return "BuyRequest{" +
                "buyId=" + buyId +
                ", userId=" + userId +
                ", approvedCarId=" + approvedCarId +
                ", dateOfRequest=" + dateOfRequest +
                ", isApproved=" + isApproved +
                ", inspectionTeamId=" + inspectionTeamId +
                ", isDeclined=" + isDeclined +
                '}';
    }
}
