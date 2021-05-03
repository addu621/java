package com.example.cars.entities;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "InspectionDetails")
public class InspectionDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer postId;

    @Column
    private Integer price;

    @Column
    private Boolean isReadyForSale;

    @Column
    private Double mileage;

    @Column
    private Integer Engine;

    @Column
    private Double maxPower;

    @Column
    private Integer torque;

    @Column
    private Integer seats;

    @Column
    private String color;

    @Column
    private Integer gearBox;

    @Column
    private String driverType;

    @Column
    private String steeringType;

    @Column
    private Double turningRadius;

    @Column
    private String frontBrakeType;

    @Column
    private String rearBrakeType;

    @Column
    private String tyreType;

    @Column
    private Integer wheelSize;

    @Column
    private Integer cargoVolume;

    @Column
    private String engineType;

    @Column
    private Integer numberOfCylinder;

    @Column
    private Integer valvesPerCylinder;

    @Column
    private Integer length;

    @Column
    private Integer width;

    @Column
    private Integer height;

    @Column
    private Integer groundClearance;

    @Column
    private Integer wheelBase;

    @Column
    private Integer grossWeight;

    @Column(name = "carPic1",length = 16777215)
    private byte[] carPic1;

    @Column(name = "carPic2",length = 16777215)
    private byte[] carPic2;

    @Column(name = "carPic3",length = 16777215)
    private byte[] carPic3;

    @Column(name = "carPic4",length = 16777215)
    private byte[] carPic4;

    @Column(name = "carPic5",length = 16777215)
    private byte[] carPic5;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getReadyForSale() {
        return isReadyForSale;
    }

    public void setReadyForSale(Boolean readyForSale) {
        isReadyForSale = readyForSale;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Integer getEngine() {
        return Engine;
    }

    public void setEngine(Integer engine) {
        Engine = engine;
    }

    public Double getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Double maxPower) {
        this.maxPower = maxPower;
    }

    public Integer getTorque() {
        return torque;
    }

    public void setTorque(Integer torque) {
        this.torque = torque;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getGearBox() {
        return gearBox;
    }

    public void setGearBox(Integer gearBox) {
        this.gearBox = gearBox;
    }

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public String getSteeringType() {
        return steeringType;
    }

    public void setSteeringType(String steeringType) {
        this.steeringType = steeringType;
    }

    public Double getTurningRadius() {
        return turningRadius;
    }

    public void setTurningRadius(Double turningRadius) {
        this.turningRadius = turningRadius;
    }

    public String getFrontBrakeType() {
        return frontBrakeType;
    }

    public void setFrontBrakeType(String frontBrakeType) {
        this.frontBrakeType = frontBrakeType;
    }

    public String getRearBrakeType() {
        return rearBrakeType;
    }

    public void setRearBrakeType(String rearBrakeType) {
        this.rearBrakeType = rearBrakeType;
    }

    public String getTyreType() {
        return tyreType;
    }

    public void setTyreType(String tyreType) {
        this.tyreType = tyreType;
    }

    public Integer getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(Integer wheelSize) {
        this.wheelSize = wheelSize;
    }

    public Integer getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(Integer cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Integer getNumberOfCylinder() {
        return numberOfCylinder;
    }

    public void setNumberOfCylinder(Integer numberOfCylinder) {
        this.numberOfCylinder = numberOfCylinder;
    }

    public Integer getValvesPerCylinder() {
        return valvesPerCylinder;
    }

    public void setValvesPerCylinder(Integer valvesPerCylinder) {
        this.valvesPerCylinder = valvesPerCylinder;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getGroundClearance() {
        return groundClearance;
    }

    public void setGroundClearance(Integer groundClearance) {
        this.groundClearance = groundClearance;
    }

    public Integer getWheelBase() {
        return wheelBase;
    }

    public void setWheelBase(Integer wheelBase) {
        this.wheelBase = wheelBase;
    }

    public Integer getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Integer grossWeight) {
        this.grossWeight = grossWeight;
    }

    public byte[] getCarPic1() {
        return carPic1;
    }

    public void setCarPic1(byte[] carPic1) {
        this.carPic1 = carPic1;
    }

    public byte[] getCarPic2() {
        return carPic2;
    }

    public void setCarPic2(byte[] carPic2) {
        this.carPic2 = carPic2;
    }

    public byte[] getCarPic3() {
        return carPic3;
    }

    public void setCarPic3(byte[] carPic3) {
        this.carPic3 = carPic3;
    }

    public byte[] getCarPic4() {
        return carPic4;
    }

    public void setCarPic4(byte[] carPic4) {
        this.carPic4 = carPic4;
    }

    public byte[] getCarPic5() {
        return carPic5;
    }

    public void setCarPic5(byte[] carPic5) {
        this.carPic5 = carPic5;
    }
}
