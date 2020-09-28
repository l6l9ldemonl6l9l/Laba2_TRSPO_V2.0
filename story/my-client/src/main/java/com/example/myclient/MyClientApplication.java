package com.example.myclient;

import com.example.models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class MyClientApplication implements CommandLineRunner {

    private RestTemplate restTemplate;
    private String baseUrl;

    public static void main(String[] args) {
        SpringApplication.run(MyClientApplication.class, args);
    }

    private void createEntities(RestTemplate restTemplate, String baseUrl) {
        Date date1 = new Date();
        Crow crow1 = new Crow("Евгения", date1, 33, 30);
        Crow crow2 = new Crow("Анастасия", date1, 40, 35);

        restTemplate.postForObject(baseUrl + "/crows", crow1, Crow.class);
        restTemplate.postForObject(baseUrl + "/crows", crow2, Crow.class);

        Date date2 = new Date();
        Fox fox1 = new Fox("Ирина", date2, 30, 25);
        Fox fox2 = new Fox("Лена", date2, 40, 75);

        restTemplate.postForObject(baseUrl + "/foxes", fox1, Fox.class);
        restTemplate.postForObject(baseUrl + "/foxes", fox2, Fox.class);

        Terrain terrain = new Terrain("Лес", 50);

        restTemplate.postForObject(baseUrl + "/terrains", terrain, Terrain.class);

        Food food1 = new Food(40, "Сыр", new Date());
        Food food2 = new Food(50, "Сырник", new Date());
        Food food3 = new Food(60, "Плавленый сыр", new Date());

        restTemplate.postForObject(baseUrl + "/foods", food1, Food.class);
        restTemplate.postForObject(baseUrl + "/foods", food2, Food.class);
        restTemplate.postForObject(baseUrl + "/foods", food3, Food.class);

        Date Birthday = new Date(1212121212121L);
        Deity deity = new Deity("Крылов", Birthday);

        restTemplate.postForObject(baseUrl + "/deities", deity, Deity.class);
    }

    private Crow getCrow(String crowName) {
        return restTemplate.getForObject(baseUrl + "/crows/search/findByName?name=" + crowName, Crow.class);
    }

    private Fox getFox(String foxName) {
        return restTemplate.getForObject(baseUrl + "/foxes/search/findByName?name=" + foxName, Fox.class);
    }

    private Food getFood(String foodKind) {
        return restTemplate.getForObject(baseUrl + "/foods/search/findByKindFood?kind=" + foodKind, Food.class);
    }

    private Terrain getTerrain(String terrainName) {
        return restTemplate.getForObject(baseUrl + "/terrains/search/findByName?name=" + terrainName, Terrain.class);
    }

    private Deity getDeity(String deityName) {
        return restTemplate.getForObject(baseUrl + "/deities/search/findByName?name=" + deityName, Deity.class);
    }

    @Override
    public void run(String... args) {
        restTemplate = new RestTemplate();
        baseUrl = "http://localhost:8080";


        createEntities(restTemplate, baseUrl);


        Crow crow1 = getCrow("Евгения");
        Crow crow2 = getCrow("Анастасия");

        Fox fox1 = getFox("Ирина");
        Fox fox2 = getFox("Лена");

        Terrain terrain = getTerrain("Лес");

        Food food1 = getFood("Сыр");
        Food food2 = getFood("Сырник");
        Food food3 = getFood("Плавленый сыр");

        Deity deity = getDeity("Крылов");


        AnimalLife story1 = new AnimalLife(fox1, crow1, terrain);
        AnimalLife story2 = new AnimalLife(fox2, crow2, terrain);

        DeityLife fairyStory = new DeityLife(deity);

        fairyStory.addFood(food1);
        fairyStory.addFood(food2);
        fairyStory.addFood(food3);

        fairyStory.addAnimalLife(story1);
        fairyStory.addAnimalLife(story2);

        fairyStory.showInformation();

        Scanner in = new Scanner(System.in);
        System.out.println("Какую еду дать какой паре животных?(введите 2 числа)\n");
        int choose1 = in.nextInt();
        int choose2 = in.nextInt();

        fairyStory.startStory(choose1, choose2);
        fairyStory.showInformation();

        System.out.println("Какой паре животных вы желаете повысить опыт но понизить энергию?(введите 1 число)\n");
        choose1 = in.nextInt();
        in.close();

        fairyStory.train(choose1);
        fairyStory.showInformation();
    }
}
