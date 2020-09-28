package com.example.models;

import java.util.HashMap;

public class DeityLife {
    private final HashMap<Long, AnimalLife> animalsLife = new HashMap<>();
    private final HashMap<Long, Food> foods = new HashMap<>();
    private final Deity deity;

    public DeityLife(Deity deity) {
        this.deity = deity;
    }

    public void addAnimalLife(AnimalLife animalLife) {
        animalsLife.put(animalLife.getId(), animalLife);
    }

    public void addFood(Food food) {
        foods.put(food.getId(), food);
    }

    public void deletFood(Long id) {
        if (getFoodById(id) != null) {
            foods.remove(id);
        }
    }

    public AnimalLife getAnimalLifeById(Long animalLifeId) {
        return animalsLife.getOrDefault(animalLifeId, null);
    }

    public Food getFoodById(Long foodId) {
        return foods.getOrDefault(foodId, null);
    }

    public void startStory(int choose1, int choose2) {
        Long testFoodId = null;

        int iter1 = 1;
        for (AnimalLife valueAnimal : animalsLife.values()) {
            int iter2 = 1;

            for (Food valueFood : foods.values()) {
                if (iter1 == choose1 & iter2 == choose2) {
                    loseFood(valueAnimal.getId(), valueFood.getId());
                    testFoodId = valueFood.getId();
                }
                iter2 += 1;
            }
            iter1 += 1;
        }

        deletFood(testFoodId);
    }

    public void train(int choose1) {
        int iter1 = 1;
        for (AnimalLife valueAnimal : animalsLife.values()) {
            if (iter1 == choose1) {
                valueAnimal.trainingAnimals();
            }
            iter1 += 1;
        }
    }

    public void showInformation() {
        deity.showInformationAboutAuthor();
        showInformationAboutFoods();
        showInformationAboutAminals();
    }

    public void showInformationAboutFoods() {
        int iterator = 1;
        for (Food value : foods.values()) {
            System.out.print(iterator + ". ");
            value.showInformationAboutFood();
            iterator += 1;
        }
    }

    public void showInformationAboutAminals() {
        int iterator = 1;
        for (AnimalLife value : animalsLife.values()) {
            System.out.print(iterator + ". ");
            value.showInformation();
            iterator += 1;
        }
    }

    public void loseFood(Long idAnimal, Long idFood) {
        AnimalLife animals = getAnimalLifeById(idAnimal);
        Food food = getFoodById(idFood);

        animals.foodDispute(food);

        animals.toString(animals.getStatus());
    }
}
