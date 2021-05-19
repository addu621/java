package com.example.cars.entities;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table
public class InspectionTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer inspectionTeamId;

    @Column
    private String name;

    @Column
    private String location;

    @Column(columnDefinition = "integer default 0")
    private Integer pendingRequests;

    @Column(columnDefinition = "integer default 0")
    private Integer totalRequests;

    @Column
    private String email;

    public Integer getInspectionTeamId() {
        return inspectionTeamId;
    }

    public void setInspectionTeamId(Integer inspectionTeamId) {
        this.inspectionTeamId = inspectionTeamId;
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

    @Override
    public String toString() {
        return "InspectionTeam{" +
                "inspectionTeamId=" + inspectionTeamId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", pendingRequests=" + pendingRequests +
                ", totalRequests=" + totalRequests +
                ", email='" + email + '\'' +
                '}';
    }
}
