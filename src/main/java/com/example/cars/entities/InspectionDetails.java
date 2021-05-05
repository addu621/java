package com.example.cars.entities;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "InspectionDetails")
public class InspectionDetails {

    public InspectionDetails(){}
    @Id
    @Column
    private Integer postId;

    @JoinColumn
    @OneToOne
    private InspectionTeam inspectionTeam;

    @Column
    private Integer price;

    @Column
    private Boolean isReadyForSale;

    @Column
    private Double mileage;

    @Column
    private Integer engine;

    @Column
    private Double maxPower;

    @Column
    private Integer torque;

    @Column
    private Integer seats;

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

    @Column
    private Boolean adjustableSteering;

    @Column
    private Boolean adjustableSeatHeight;

    @Column
    private Integer powerWindows;

    @Column
    private Boolean centralLocking;

    @Column
    private Boolean autoClimateControl;

    @Column
    private Boolean adjustableHeadRest;

    @Column
    private Boolean pushStartButton;

    @Column
    private Boolean smartDisplay;

    @Column
    private Integer airBags;

    @Column
    private Boolean fogLamps;

    @Column
    private Boolean rearWiper;

    @Column
    private String bodyColor;

    @Column
    private Boolean motorisedORVM;

    @Column
    private Boolean reverseGearCamera;

    @Column
    private Boolean parkingSensors;

    @Column
    private Boolean adjustableHeadlights;

    @Column
    private String multimediaSystem;

    @Column
    private Boolean steeringMediaControls;

    @Column
    private Integer speakers;

    @Column
    private Integer woofers;

    @Column
    private Boolean navigation;

    @Column
    private Boolean rearTftScreen;

    @Column
    private Integer ownership;

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
        return engine;
    }

    public void setEngine(Integer engine) {
        engine = engine;
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

    public Boolean getAdjustableSteering() {
        return adjustableSteering;
    }

    public void setAdjustableSteering(Boolean adjustableSteering) {
        this.adjustableSteering = adjustableSteering;
    }

    public Boolean getAdjustableSeatHeight() {
        return adjustableSeatHeight;
    }

    public void setAdjustableSeatHeight(Boolean adjustableSeatHeight) {
        this.adjustableSeatHeight = adjustableSeatHeight;
    }

    public Integer getPowerWindows() {
        return powerWindows;
    }

    public void setPowerWindows(Integer powerWindows) {
        this.powerWindows = powerWindows;
    }

    public Boolean getCentralLocking() {
        return centralLocking;
    }

    public void setCentralLocking(Boolean centralLocking) {
        this.centralLocking = centralLocking;
    }

    public Boolean getAutoClimateControl() {
        return autoClimateControl;
    }

    public void setAutoClimateControl(Boolean autoClimateControl) {
        this.autoClimateControl = autoClimateControl;
    }

    public Boolean getAdjustableHeadRest() {
        return adjustableHeadRest;
    }

    public void setAdjustableHeadRest(Boolean adjustableHeadRest) {
        this.adjustableHeadRest = adjustableHeadRest;
    }

    public Boolean getPushStartButton() {
        return pushStartButton;
    }

    public void setPushStartButton(Boolean pushStartButton) {
        this.pushStartButton = pushStartButton;
    }

    public Boolean getSmartDisplay() {
        return smartDisplay;
    }

    public void setSmartDisplay(Boolean smartDisplay) {
        this.smartDisplay = smartDisplay;
    }

    public Integer getAirBags() {
        return airBags;
    }

    public void setAirBags(Integer airBags) {
        this.airBags = airBags;
    }

    public Boolean getFogLamps() {
        return fogLamps;
    }

    public void setFogLamps(Boolean fogLamps) {
        this.fogLamps = fogLamps;
    }

    public Boolean getRearWiper() {
        return rearWiper;
    }

    public void setRearWiper(Boolean rearWiper) {
        this.rearWiper = rearWiper;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public Boolean getMotorisedORVM() {
        return motorisedORVM;
    }

    public void setMotorisedORVM(Boolean motorisedORVM) {
        this.motorisedORVM = motorisedORVM;
    }

    public Boolean getReverseGearCamera() {
        return reverseGearCamera;
    }

    public void setReverseGearCamera(Boolean reverseGearCamera) {
        this.reverseGearCamera = reverseGearCamera;
    }

    public Boolean getParkingSensors() {
        return parkingSensors;
    }

    public void setParkingSensors(Boolean parkingSensors) {
        this.parkingSensors = parkingSensors;
    }

    public Boolean getAdjustableHeadlights() {
        return adjustableHeadlights;
    }

    public void setAdjustableHeadlights(Boolean adjustableHeadlights) {
        this.adjustableHeadlights = adjustableHeadlights;
    }

    public String getMultimediaSystem() {
        return multimediaSystem;
    }

    public void setMultimediaSystem(String multimediaSystem) {
        this.multimediaSystem = multimediaSystem;
    }

    public Boolean getSteeringMediaControls() {
        return steeringMediaControls;
    }

    public void setSteeringMediaControls(Boolean steeringMediaControls) {
        this.steeringMediaControls = steeringMediaControls;
    }

    public Integer getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Integer speakers) {
        this.speakers = speakers;
    }

    public Integer getWoofers() {
        return woofers;
    }

    public void setWoofers(Integer woofers) {
        this.woofers = woofers;
    }

    public Boolean getNavigation() {
        return navigation;
    }

    public void setNavigation(Boolean navigation) {
        this.navigation = navigation;
    }

    public Boolean getRearTftScreen() {
        return rearTftScreen;
    }

    public void setRearTftScreen(Boolean rearTftScreen) {
        this.rearTftScreen = rearTftScreen;
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

    public InspectionTeam getInspectionTeam() {
        return inspectionTeam;
    }

    public void setInspectionTeam(InspectionTeam inspectionTeam) {
        this.inspectionTeam = inspectionTeam;
    }

    public Integer getOwnership() {
        return ownership;
    }

    public void setOwnership(Integer ownership) {
        this.ownership = ownership;
    }
}
