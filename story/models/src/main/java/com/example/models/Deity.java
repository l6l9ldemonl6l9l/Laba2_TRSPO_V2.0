package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Deity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private Date age;

    public Deity() {
    }

    public Deity(String name, Date age) {
        this.name = name;
        this.age = age;
    }

    public void showInformationAboutAuthor() {
        System.out.println("Автор:" + name + ". Дата рождения:" + age + ".\n");
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

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }
}
