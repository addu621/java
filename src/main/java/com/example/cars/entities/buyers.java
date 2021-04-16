package com.example.cars.entities;

import javax.persistence.*;
import java.lang.reflect.Array;

@Entity
@Table(name = "buyers")
public class buyers {

    public buyers(Integer userId, Array purchase) {
        this.userId = userId;
        this.purchase = purchase;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer userId;

    @Column
    private Array purchase;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Array getPurchase() {
        return purchase;
    }

    public void setPurchase(Array purchase) {
        this.purchase = purchase;
    }
}
