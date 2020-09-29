package com.example.myserver.repository;

import com.example.models.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface FoodRepository extends CrudRepository <Food, Long > {
    List<Food> findByKindFood(String kindFood);
    boolean existsById(UUID id);
    boolean existsByKindFood(String kindFood);
}
