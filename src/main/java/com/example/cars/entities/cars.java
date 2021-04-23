package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class cars {

    public cars(){}
    public cars(Integer carId, CarsBrand brandId, String carName) {
        this.carId = carId;
        this.brandId = brandId;
        this.carName = carName;
    }

    @Id
    @Column
    private Integer carId;

    @JoinColumn(name = "brandId")
    @ManyToOne
    private CarsBrand brandId;

    @Column
    private String carName;

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
}
