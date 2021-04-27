package com.example.cars.entities;

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

    @Lob
    @Column(name = "insuranceCertificate")
    private byte[] insuranceCertificate;

    @Lob
    @Column(name = "registration_certificate")
    private byte[] registrationCertificate;


    @Column(columnDefinition = "boolean default false")
    private Boolean isSold;

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
}
