package com.example.cars.entities;


import javax.persistence.*;

@Entity
@Table(name = "modelDetails")
public class modelDetails {

    public modelDetails(Integer modelId, Integer carId, String modelName) {
        this.modelId = modelId;
        this.carId = carId;
        this.modelName = modelName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer modelId;

    @Column
    private Integer carId;

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

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
