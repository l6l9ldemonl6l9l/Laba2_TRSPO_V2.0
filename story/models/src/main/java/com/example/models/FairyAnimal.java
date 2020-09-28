package com.example.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class FairyAnimal {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private Date lastLunchTime;
    private int energy;

    public FairyAnimal() {
    }

    public FairyAnimal(String name, Date lastLunchTime, int energy) {
        this.name = name;
        this.lastLunchTime = lastLunchTime;
        this.energy = energy;
    }

    public void fatigue() {
        if (energy > 5) {
            this.energy -= 5;
        }
    }

    public void eat() {
        this.lastLunchTime = new Date();
        this.energy += 20;
    }

    public void hunting() {
        if (energy > 10) {
            this.energy -= 10;
        }
    }

    public void showInformation() {
        System.out.print(name + ". Животное ело последний раз: " + lastLunchTime + ". Текущая енергия: " + energy + ".");
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastLunchTime() {
        return lastLunchTime;
    }

    public void setLastLunchTime(Date lastLunchTime) {
        this.lastLunchTime = lastLunchTime;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
