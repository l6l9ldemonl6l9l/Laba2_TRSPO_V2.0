package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Food {

    @Id
    @GeneratedValue
    private UUID id;

    private int taste;
    private String kindFood;
    private Date birthday;

    public Food() {
    }

    public Food(int taste, String kindFood, Date birthday) {
        this.taste = taste;
        this.kindFood = kindFood;
        this.birthday = birthday;
    }

    public void showInformationAboutFood() {
        System.out.println("Еда : " + kindFood + ". Дата создания: " + birthday + ". Вкус: " + taste + ".\n");
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getTaste() {
        return taste;
    }

    public void setTaste(int taste) {
        this.taste = taste;
    }

    public String getKindFood() {
        return kindFood;
    }

    public void setKindFood(String kindFood) {
        this.kindFood = kindFood;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
