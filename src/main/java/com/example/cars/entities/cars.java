package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class cars {

    public cars(Integer carId, carsBrand brandId, String carName) {
        this.carId = carId;
        this.brandId = brandId;
        this.carName = carName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer carId;

    @JoinColumn
    @ManyToOne
    private carsBrand brandId;

    @Column
    private String carName;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public carsBrand getBrandId() {
        return brandId;
    }

    public void setBrandId(carsBrand brandId) {
        this.brandId = brandId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
