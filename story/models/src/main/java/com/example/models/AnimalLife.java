package com.example.models;

import java.util.UUID;

public class AnimalLife {
    private UUID id;
    private Fox fox;
    private Crow crow;
    private Terrain terrain;
    private Status status;

    public AnimalLife(Fox fox, Crow crow, Terrain terrain) {
        this.id = UUID.randomUUID();
        this.fox = fox;
        this.crow = crow;
        this.terrain = terrain;
        this.status = Status.noEating;
    }

    public UUID getId() {
        return id;
    }

    public Status getStatus() {
        return this.status;
    }

    public void showInformation() {
        fox.showInformationAboutFox();
        crow.showInformationAboutCrow();
        terrain.showInformationAboutTerrain();
        toString(status);
    }

    public void foodDispute(Food food) {
        if (food.getTaste() < terrain.getSizeBeauty()) {
            lunch();
        } else {
            this.status = Status.noEating;
        }
    }

    public void trainingAnimals() {
        fox.training();
        crow.training();
    }

    public void lunch() {
        fox.hunting();
        fox.voiceVin();
        if (crow.getSizeMind() < fox.getSizeCunning() * terrain.getSizeBeauty()) {
            crow.voiceFail();
            fox.eat();
            this.status = Status.foxEating;
        } else {
            crow.voiceVin();
            crow.eat();
            fox.voiceFail();
            this.status = Status.crowEating;
        }
    }

    public void toString(Status status) {
        if (status == Status.noEating) {
            System.out.println("Статус: Ожидание еды.(или найденую еду животные не едят)\n");
        }
        if (status == Status.foxEating) {
            System.out.println("Статус: Лиса ест.\n");
        }
        if (status == Status.crowEating) {
            System.out.println("Сатус: Ворнона ест.\n");
        }
    }
}
