package com.example.myserver.controllers;

import com.example.models.Food;
import com.example.myserver.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoodController {
    private final FoodRepository FoodRepository;

    public FoodController(FoodRepository FoodRepository){
        this.FoodRepository = FoodRepository;
    }

    public void createFood(String kindFood) {
        if(checkExistByKindFood(kindFood))
            throw new IllegalArgumentException("This kindFood number already exists");
        int taste=10;
        Food Food= new Food(taste, kindFood);
        FoodRepository.save(Food);

        System.out.println("\u001B[33m" + "New Food"+ Food.getKindFood() +" added" + "\u001B[0m");
    }

    public Food getFoodByKindFood(String kindFood) throws IllegalArgumentException {
        List<Food> foundFood = FoodRepository.findByKindFood(kindFood);

        if(foundFood.size() == 0){
            throw new IllegalArgumentException("Food not found");
        }

        return foundFood.get(0);
    }

    public boolean checkExist(UUID FoodId){
        return FoodRepository.existsById(FoodId);
    }

    public boolean checkExistByKindFood(String kindFood){
        return FoodRepository.existsByKindFood(kindFood);
    }
}
