package com.example.cars.entities;

import javax.persistence.*;

@Entity
@Table(name = "carsBrand")
public class carsBrand {

    public carsBrand(Integer brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer brandId;

    @Column
    private String brandName;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
