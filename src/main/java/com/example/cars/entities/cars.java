package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class cars {

    public cars(){}
    public cars(Integer carId, CarsBrand brandId, String carName, String carType) {
        this.carId = carId;
        this.brandId = brandId;
        this.carName = carName;
        this.carType = carType;
    }

    @Id
    @Column
    private Integer carId;

    @JoinColumn(name = "brandId")
    @ManyToOne
    private CarsBrand brandId;

    @Column
    private String carName;

    @Column
    private String carType;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public CarsBrand getBrandId() {
        return brandId;
    }

    public void setBrandId(CarsBrand brandId) {
        this.brandId = brandId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carName = carType;
    }
}
