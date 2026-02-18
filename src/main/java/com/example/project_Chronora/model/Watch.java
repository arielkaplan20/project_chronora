package com.example.project_Chronora.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "watch")
public class Watch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    private Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false)
    private String brand;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(nullable = false)
    private String model;

    @NotNull
    private Double price;

    @Size(max = 50)
    private String movement; // Quartz / Automatic / Mechanical

    @Size(max = 50)
    private String material; // Steel / Gold / Titanium

    @Size(max = 500)
    @Column(name = "image")
    private String image;


    public Watch() {}

    public Watch(String brand, String model, Double price, String movement, String material, String image) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.movement = movement;
        this.material = material;
        this.image = image;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

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
}
