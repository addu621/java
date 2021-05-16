package com.example.cars.entities;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "InspectionDetails")
public class InspectionDetails {

    public InspectionDetails(){}

    public InspectionDetails(Integer postId, InspectionTeam inspectionTeam, String price, String isReadyForSale, String mileage, String maxPower, String torque, String seats, String gearBox, String driveType, String steeringType, String turningRadius, String frontBrakeType, String rearBrakeType, String tyreType, String wheelSize, String cargoVolume, String engineType, String numberOfCylinder, String valvesPerCylinder, String length, String width, String height, String groundClearance, String wheelBase, String grossWeight, String adjustableSteering, String adjustableSeatHeight, String powerWindows, String centralLocking, String autoClimateControl, String adjustableHeadRest, String pushStartButton, String smartDisplay, String airBags, String fogLamps, String rearWiper, String bodyColor, String motorisedORVM, String reverseGearCamera, String parkingSensors, String adjustableHeadlights, String multimediaSystem, String steeringMediaControls, String speakers, String woofers, String navigation, String rearTftScreen, String ownership, String bodyType, String fuelType, String displacementVolume, String doors, byte[] carPic1, byte[] carPic2, byte[] carPic3, byte[] carPic4, byte[] carPic5, String transmission) {
        this.postId = postId;
        this.inspectionTeam = inspectionTeam;
        this.price = price;
        this.isReadyForSale = isReadyForSale;
        this.mileage = mileage;
        this.maxPower = maxPower;
        this.torque = torque;
        this.seats = seats;
        this.gearBox = gearBox;
        this.driveType = driveType;
        this.steeringType = steeringType;
        this.turningRadius = turningRadius;
        this.frontBrakeType = frontBrakeType;
        this.rearBrakeType = rearBrakeType;
        this.tyreType = tyreType;
        this.wheelSize = wheelSize;
        this.cargoVolume = cargoVolume;
        this.engineType = engineType;
        this.numberOfCylinder = numberOfCylinder;
        this.valvesPerCylinder = valvesPerCylinder;
        this.length = length;
        this.width = width;
        this.height = height;
        this.groundClearance = groundClearance;
        this.wheelBase = wheelBase;
        this.grossWeight = grossWeight;
        this.adjustableSteering = adjustableSteering;
        this.adjustableSeatHeight = adjustableSeatHeight;
        this.powerWindows = powerWindows;
        this.centralLocking = centralLocking;
        this.autoClimateControl = autoClimateControl;
        this.adjustableHeadRest = adjustableHeadRest;
        this.pushStartButton = pushStartButton;
        this.smartDisplay = smartDisplay;
        this.airBags = airBags;
        this.fogLamps = fogLamps;
        this.rearWiper = rearWiper;
        this.bodyColor = bodyColor;
        this.motorisedORVM = motorisedORVM;
        this.reverseGearCamera = reverseGearCamera;
        this.parkingSensors = parkingSensors;
        this.adjustableHeadlights = adjustableHeadlights;
        this.multimediaSystem = multimediaSystem;
        this.steeringMediaControls = steeringMediaControls;
        this.speakers = speakers;
        this.woofers = woofers;
        this.navigation = navigation;
        this.rearTftScreen = rearTftScreen;
        this.ownership = ownership;
        this.bodyType = bodyType;
        this.fuelType = fuelType;
        this.displacementVolume = displacementVolume;
        this.doors = doors;
        this.transmission = transmission;
        this.carPic1 = carPic1;
        this.carPic2 = carPic2;
        this.carPic3 = carPic3;
        this.carPic4 = carPic4;
        this.carPic5 = carPic5;
    }

    @Id
    @Column
    private Integer postId;

    @JoinColumn
    @OneToOne
    private InspectionTeam inspectionTeam;

    @Column
    private String price;

    @Column
    private String isReadyForSale;

    @Column
    private String mileage;

    @Column
    private String maxPower;

    @Column
    private String torque;

    @Column
    private String seats;

    @Column
    private String gearBox;

    @Column
    private String driveType;

    @Column
    private String steeringType;

    @Column
    private String turningRadius;

    @Column
    private String frontBrakeType;

    @Column
    private String rearBrakeType;

    @Column
    private String tyreType;

    @Column
    private String wheelSize;

    @Column
    private String cargoVolume;

    @Column
    private String engineType;

    @Column
    private String numberOfCylinder;

    @Column
    private String valvesPerCylinder;

    @Column
    private String length;

    @Column
    private String width;

    @Column
    private String height;

    @Column
    private String groundClearance;

    @Column
    private String wheelBase;

    @Column
    private String grossWeight;

    @Column
    private String adjustableSteering;

    @Column
    private String adjustableSeatHeight;

    @Column
    private String powerWindows;

    @Column
    private String centralLocking;

    @Column
    private String autoClimateControl;

    @Column
    private String adjustableHeadRest;

    @Column
    private String pushStartButton;

    @Column
    private String smartDisplay;

    @Column
    private String airBags;

    @Column
    private String fogLamps;

    @Column
    private String rearWiper;

    @Column
    private String bodyColor;

    @Column
    private String motorisedORVM;

    @Column
    private String reverseGearCamera;

    @Column
    private String parkingSensors;

    @Column
    private String adjustableHeadlights;

    @Column
    private String multimediaSystem;

    @Column
    private String steeringMediaControls;

    @Column
    private String speakers;

    @Column
    private String woofers;

    @Column
    private String navigation;

    @Column
    private String rearTftScreen;

    @Column
    private String ownership;

    @Column
    private String bodyType;

    @Column
    private String fuelType;

    @Column
    private String displacementVolume;

    @Column
    private String doors;

    @Column
    private String transmission;

    @Column(length = 16777215)
    byte[] carPic1;

    @Column(length = 16777215)
    byte[] carPic2;

    @Column(length = 16777215)
    byte[] carPic3;

    @Column(length = 16777215)
    byte[] carPic4;

    @Column(length = 16777215)
    byte[] carPic5;


    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public InspectionTeam getInspectionTeam() {
        return inspectionTeam;
    }

    public void setInspectionTeam(InspectionTeam inspectionTeam) {
        this.inspectionTeam = inspectionTeam;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIsReadyForSale() {
        return isReadyForSale;
    }

    public void setIsReadyForSale(String isReadyForSale) {
        this.isReadyForSale = isReadyForSale;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(String maxPower) {
        this.maxPower = maxPower;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getSteeringType() {
        return steeringType;
    }

    public void setSteeringType(String steeringType) {
        this.steeringType = steeringType;
    }

    public String getTurningRadius() {
        return turningRadius;
    }

    public void setTurningRadius(String turningRadius) {
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

    public String getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(String wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(String cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getNumberOfCylinder() {
        return numberOfCylinder;
    }

    public void setNumberOfCylinder(String numberOfCylinder) {
        this.numberOfCylinder = numberOfCylinder;
    }

    public String getValvesPerCylinder() {
        return valvesPerCylinder;
    }

    public void setValvesPerCylinder(String valvesPerCylinder) {
        this.valvesPerCylinder = valvesPerCylinder;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGroundClearance() {
        return groundClearance;
    }

    public void setGroundClearance(String groundClearance) {
        this.groundClearance = groundClearance;
    }

    public String getWheelBase() {
        return wheelBase;
    }

    public void setWheelBase(String wheelBase) {
        this.wheelBase = wheelBase;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getAdjustableSteering() {
        return adjustableSteering;
    }

    public void setAdjustableSteering(String adjustableSteering) {
        this.adjustableSteering = adjustableSteering;
    }

    public String getAdjustableSeatHeight() {
        return adjustableSeatHeight;
    }

    public void setAdjustableSeatHeight(String adjustableSeatHeight) {
        this.adjustableSeatHeight = adjustableSeatHeight;
    }

    public String getPowerWindows() {
        return powerWindows;
    }

    public void setPowerWindows(String powerWindows) {
        this.powerWindows = powerWindows;
    }

    public String getCentralLocking() {
        return centralLocking;
    }

    public void setCentralLocking(String centralLocking) {
        this.centralLocking = centralLocking;
    }

    public String getAutoClimateControl() {
        return autoClimateControl;
    }

    public void setAutoClimateControl(String autoClimateControl) {
        this.autoClimateControl = autoClimateControl;
    }

    public String getAdjustableHeadRest() {
        return adjustableHeadRest;
    }

    public void setAdjustableHeadRest(String adjustableHeadRest) {
        this.adjustableHeadRest = adjustableHeadRest;
    }

    public String getPushStartButton() {
        return pushStartButton;
    }

    public void setPushStartButton(String pushStartButton) {
        this.pushStartButton = pushStartButton;
    }

    public String getSmartDisplay() {
        return smartDisplay;
    }

    public void setSmartDisplay(String smartDisplay) {
        this.smartDisplay = smartDisplay;
    }

    public String getAirBags() {
        return airBags;
    }

    public void setAirBags(String airBags) {
        this.airBags = airBags;
    }

    public String getFogLamps() {
        return fogLamps;
    }

    public void setFogLamps(String fogLamps) {
        this.fogLamps = fogLamps;
    }

    public String getRearWiper() {
        return rearWiper;
    }

    public void setRearWiper(String rearWiper) {
        this.rearWiper = rearWiper;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public String getMotorisedORVM() {
        return motorisedORVM;
    }

    public void setMotorisedORVM(String motorisedORVM) {
        this.motorisedORVM = motorisedORVM;
    }

    public String getReverseGearCamera() {
        return reverseGearCamera;
    }

    public void setReverseGearCamera(String reverseGearCamera) {
        this.reverseGearCamera = reverseGearCamera;
    }

    public String getParkingSensors() {
        return parkingSensors;
    }

    public void setParkingSensors(String parkingSensors) {
        this.parkingSensors = parkingSensors;
    }

    public String getAdjustableHeadlights() {
        return adjustableHeadlights;
    }

    public void setAdjustableHeadlights(String adjustableHeadlights) {
        this.adjustableHeadlights = adjustableHeadlights;
    }

    public String getMultimediaSystem() {
        return multimediaSystem;
    }

    public void setMultimediaSystem(String multimediaSystem) {
        this.multimediaSystem = multimediaSystem;
    }

    public String getSteeringMediaControls() {
        return steeringMediaControls;
    }

    public void setSteeringMediaControls(String steeringMediaControls) {
        this.steeringMediaControls = steeringMediaControls;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public String getWoofers() {
        return woofers;
    }

    public void setWoofers(String woofers) {
        this.woofers = woofers;
    }

    public String getNavigation() {
        return navigation;
    }

    public void setNavigation(String navigation) {
        this.navigation = navigation;
    }

    public String getRearTftScreen() {
        return rearTftScreen;
    }

    public void setRearTftScreen(String rearTftScreen) {
        this.rearTftScreen = rearTftScreen;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getDisplacementVolume() {
        return displacementVolume;
    }

    public void setDisplacementVolume(String displacementVolume) {
        this.displacementVolume = displacementVolume;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) { this.doors = doors; }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
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
