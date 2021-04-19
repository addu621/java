package com.example.cars.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_details")
public class User{
    @Id
    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Column
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private boolean isVerified;

    @Column(name = "verification_token",nullable = false)
    private String verificationToken;

    @Column(nullable = false)
    private Date verification_date;

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public Date getVerification_date() {
        return verification_date;
    }

    public void setVerification_date(Date verification_date) {
        this.verification_date = verification_date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isVerified=" + isVerified +
                ", verificationToken='" + verificationToken + '\'' +
                ", verification_date=" + verification_date +
                '}';
    }
}

