package com.example.cars.entities;


import javax.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer adminId;

    @Column
    private String adminName;

    @Id
    @Column
    private String adminEmail;

    @Column
    private String adminPassword;

    public Admin(){};

    public Admin(String adminName, String adminEmail, String adminPassword) {
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
