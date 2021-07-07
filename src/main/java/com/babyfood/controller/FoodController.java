package com.babyfood.controller;

import com.babyfood.domain.Food;
import com.babyfood.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping("/api/foodAdd")
    public String addFood(Food food){
        return foodService.addFood(food);
    }

    @GetMapping("/api/foodList")
    public List<Food> foodList(Food food){
        return foodService.foodList();
    }
}
