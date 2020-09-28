package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int sizeBeauty;

    public Terrain() {
    }

    public Terrain(String name, int sizeBeauty) {
        this.name = name;
        this.sizeBeauty = sizeBeauty;
    }

    public void showInformationAboutTerrain() {
        System.out.print("Месность :" + name + ". Красота:");

        if (sizeBeauty < 20) {
            System.out.println(" ниже среднего.");
        }

        if (sizeBeauty >= 20 & sizeBeauty <= 60) {
            System.out.println(" красиво.");
        }

        if (sizeBeauty > 60) {
            System.out.println(" очень красиво.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeBeauty() {
        return sizeBeauty;
    }

    public void setSizeBeauty(int sizeBeauty) {
        this.sizeBeauty = sizeBeauty;
    }
}
