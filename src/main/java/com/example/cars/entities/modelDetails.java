package com.example.cars.entities;


import javax.persistence.*;

@Entity
@Table(name = "modelDetails")
public class modelDetails {

    modelDetails(){}
    public modelDetails(Integer modelId, cars carId, String modelName) {
        this.modelId = modelId;
        this.carId = carId;
        this.modelName = modelName;
    }

    @Id
    @Column
    private Integer modelId;

    @JoinColumn(name = "carId")
    @ManyToOne
    private cars carId;

    @Column
    private String modelName;

    /*
        more details to be included
    */

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public cars getCarId() {
        return carId;
    }

    public void setCarId(cars carId) {
        this.carId = carId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
