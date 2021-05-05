package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer dealerId;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private Integer pendingRequests;

    @Column
    private Integer totalRequests;

    @Column
    private String email;

    public Integer getId() {
        return dealerId;
    }

    public void setId(Integer id) {
        this.dealerId = dealerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPendingRequests() {
        return pendingRequests;
    }

    public void setPendingRequests(Integer pendingRequests) {
        this.pendingRequests = pendingRequests;
    }

    public Integer getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(Integer totalRequests) {
        this.totalRequests = totalRequests;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
