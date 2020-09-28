package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
