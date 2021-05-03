package com.example.cars.entities;
import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "image_table")
public class ImageModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")

    private String name;

    @Column(name = "type")

    private String type;

        //image bytes can have large lengths so we specify a value

        //which is more than the default length for picByte column

    @Column(name = "picByte")

    private Blob picByte;

    public ImageModel(){}
    public ImageModel(String name, String type, Blob picByte) {
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getType() {

        return type;

    }

    public void setType(String type) {

        this.type = type;

    }

    public Blob getPicByte() {

        return picByte;

    }

    public void setPicByte(Blob picByte) {

        this.picByte = picByte;

    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", picByte=" + picByte +
                '}';
    }
}
