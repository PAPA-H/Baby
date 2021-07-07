package com.babyfood;

import com.babyfood.domain.Food;
import com.babyfood.domain.Parent;
import com.babyfood.repo.FoodRepo;
import com.babyfood.repo.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class initDB implements ApplicationRunner {

    @Autowired
    ParentRepo parentRepo;
    @Autowired
    FoodRepo foodRepo;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        addFood();
        addParent();
    }
    public void addFood(){
        Food food1 = new Food();
        food1.setFoodName("한우근대죽");
        food1.setStock(3);
        food1.setSize("160g");
        food1.setOrderedDate(LocalDate.now());
        food1.setExpiryDate(LocalDate.of(2021,8,30));
        food1.setMadeBy("베베쿡");
        foodRepo.save(food1);

        Food food2 = new Food();
        food2.setFoodName("닭고기야채죽");
        food2.setStock(3);
        food2.setSize("160g");
        food2.setOrderedDate(LocalDate.now());
        food2.setExpiryDate(LocalDate.of(2021,8,30));
        food2.setMadeBy("베베쿡");
        foodRepo.save(food2);

    }

    public void addParent(){
        Parent parent1 = new Parent();
        parent1.setName("최호순");
        parent1.setNick("아빠");
        parentRepo.save(parent1);

        Parent parent2 = new Parent();
        parent2.setName("최윤희");
        parent2.setNick("엄마");
        parentRepo.save(parent2);

    }
}
