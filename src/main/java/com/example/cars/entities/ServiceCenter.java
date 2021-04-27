package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "ServiceCenter")
public class ServiceCenter {

    public ServiceCenter(Integer centerId, String centerName, String centerLocation) {
        this.centerId = centerId;
        this.centerName = centerName;
        this.centerLocation = centerLocation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer centerId;

    @Column
    private String centerName;

    @Column
    private String centerLocation;

    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterLocation() {
        return centerLocation;
    }

    public void setCenterLocation(String centerLocation) {
        this.centerLocation = centerLocation;
    }
}
