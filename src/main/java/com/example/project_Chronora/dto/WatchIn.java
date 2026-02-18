package com.example.project_Chronora.dto;

import com.example.project_Chronora.model.Watch;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class WatchIn implements Serializable {

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false
    private String brand;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false)
    private String model;

    @NotNull
    private Double price;

    @Size(max = 50)
    private String movement;

    @Size(max = 50)
    private String material;

    @Size(max = 500)
    @Column(name = "image")
    private String image;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Watch toWatch(WatchIn watchIn) {
            return new Watch(
                    watchIn.getBrand(),
                    watchIn.getModel(),
                    watchIn.getPrice(),
                    watchIn. getMovement(),
                    watchIn.getMaterial(),
                    watchIn.getImage()
            );
        }

        public void updateWatch(Watch watch) {
            watch.setBrand(brand);
            watch.setModel(model);
            watch.setPrice(price);
            watch.setMovement(movement);
            watch.setMaterial(material);
            watch.setImage(image);
        }
    }


