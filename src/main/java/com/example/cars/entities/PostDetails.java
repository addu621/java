package com.example.cars.entities;

import javassist.runtime.Inner;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "postDetails")
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer postId;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User userId;

    @Column
    private Integer inspectionTeamId;

    @Column
    private Date dateOfPost;

    @JoinColumn(name = "modelId")
    @ManyToOne
    private modelDetails modelID;

    @Column(nullable = false)
    private Integer kmsRun;

    @Column(nullable = false)
    private Integer modelYear;

    @Column(columnDefinition = "boolean default false")
    private Boolean isApproved;

    @Column
    private String location;

    @Column(name = "insuranceCertificate",length = 16777215)
    private byte[] insuranceCertificate;

    @Column(name = "registration_certificate",length = 16777215)
    private byte[] registrationCertificate;

    @Column(columnDefinition = "boolean default false")
    private boolean isInspectionDone;

    @Column(columnDefinition = "boolean default false")
    private Boolean isSold;

    @Column(columnDefinition = "boolean default false")
    private boolean isSentForInspection;

    @Column
    private String registrationYear;

    @Column
    private String registrationNumber;

    @Column
    private String address;

    public PostDetails(){}
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

    public byte[] getInsuranceCertificate() {
        return insuranceCertificate;
    }

    public void setInsuranceCertificate(byte[] aadharCard) {
        this.insuranceCertificate = aadharCard;
    }

    public byte[] getRegistrationCertificate() {
        return registrationCertificate;
    }

    public void setRegistrationCertificate(byte[] rc) {
        this.registrationCertificate = rc;
    }

    public Boolean getSold() {
        return isSold;
    }

    public void setSold(Boolean sold) {
        isSold = sold;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isInspectionDone() {
        return isInspectionDone;
    }

    public void setInspectionDone(boolean inspectionDone) {
        isInspectionDone = inspectionDone;
    }

    public boolean isSentForInspection() {
        return isSentForInspection;
    }

    public void setSentForInspection(boolean sentForInspection) {
        isSentForInspection = sentForInspection;
    }

    public Integer getInspectionTeamId() {
        return inspectionTeamId;
    }

    public void setInspectionTeamId(Integer inspectionTeamId) {
        this.inspectionTeamId = inspectionTeamId;
    }

    public String getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

