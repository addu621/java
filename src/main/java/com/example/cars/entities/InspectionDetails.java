package com.example.cars.entities;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "InspectionDetails")
public class InspectionDetails {

    public InspectionDetails(Integer postId, Integer price, Boolean isReadyForSale) {
        this.postId = postId;
        this.price = price;
        this.isReadyForSale = isReadyForSale;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer postId;

    @Column
    private Integer price;

    @Column
    private Boolean isReadyForSale;

//    @Column
//    private Blob carPic1;
//
//    @Column
//    private Blob carPic2;
//
//    @Column
//    private Blob carPic3;

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
}
