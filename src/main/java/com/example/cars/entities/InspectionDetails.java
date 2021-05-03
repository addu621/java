package com.example.cars.entities;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "InspectionDetails")
public class InspectionDetails {

    public InspectionDetails(Integer postId, Integer price, Boolean isReadyForSale, Double mileage, Integer engine, Double maxPower, Integer torque, Integer seats, Integer gearBox, String driverType, String steeringType, Double turningRadius, String frontBrakeType, String rearBrakeType, String tyreType, Integer wheelSize, Integer cargoVolume, String engineType, Integer numberOfCylinder, Integer valvesPerCylinder, Integer length, Integer width, Integer height, Integer groundClearance, Integer wheelBase, Integer grossWeight, Boolean adjustableSteering, Boolean adjustableSeatHeight, Integer powerWindows, Boolean centralLocking, Boolean autoClimateControl, Boolean adjustableHeadRest, Boolean pushStartButton, Boolean smartDisplay, Integer airBags, Boolean fogLamps, Boolean rearWiper, String bodyColor, Boolean motorisedORVM, Boolean reverseGearCamera, Boolean parkingSensors, Boolean adjustableHeadlights, String multimediaSystem, Boolean steeringMediaControls, Integer speakers, Integer woofers, Boolean navigation, Boolean rearTftScreen) {
        this.postId = postId;
        this.price = price;
        this.isReadyForSale = isReadyForSale;
        this.mileage = mileage;
        this.engine = engine;
        this.maxPower = maxPower;
        this.torque = torque;
        this.seats = seats;
        this.gearBox = gearBox;
        this.driverType = driverType;
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
    }

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
}
