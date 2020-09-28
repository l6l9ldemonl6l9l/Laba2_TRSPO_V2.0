package com.example.myserver.repository;

import com.example.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {

    Food findByKindFood(String kind);
}
