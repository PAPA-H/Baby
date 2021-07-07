package com.babyfood.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Food {

    @Id    @GeneratedValue
    @Column(name="FOOD_ID")
    private Long id;
    private String foodName;
    private String madeBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;
    private int stock;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderedDate;
    private String size;

    public void addStock(int count){
        this.stock += count;
    }
    public void fedStock(int count){
        int leftStock = this.stock - count;
        if(leftStock < 0){
            throw new RuntimeException("Not Enough Stock!");
        }
        this.stock = leftStock;
    }

}
