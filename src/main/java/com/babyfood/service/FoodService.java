package com.babyfood.service;

import com.babyfood.domain.Food;
import com.babyfood.repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepo foodRepo;

    public String addFood(Food food){
        foodRepo.save(food);
        return "Food added Success";
    }

    public List<Food> foodList(){
        List<Food> food = foodRepo.findAll();
        return food;
    }

    public Food getOne(Long foodId){
        return foodRepo.getById(foodId);
    }
}
