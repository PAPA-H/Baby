package com.babyfood.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Feed {
    @Id @GeneratedValue
    @Column(name="FEED_ID")
    private Long id;
    private LocalDateTime fedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PARENT_ID")
    private Parent parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FOOD_ID")
    private Food food;

    @Getter
    public static class Response{
        private Long feedId;
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime fedTime;
        private String fedName;
        private String fedNick;
        private String foodName;
        private String madeBy;
        private String fedSize;
        private int leftStock;

        public Response(Feed feed){
            feedId = feed.getId();
            fedTime = feed.getFedTime();
            fedName = feed.parent.getName();
            fedNick = feed.parent.getNick();
            foodName = feed.food.getFoodName();
            madeBy = feed.food.getMadeBy();
            fedSize = feed.food.getSize();
            leftStock = feed.food.getStock();
        }
    }
    @Getter
    @Setter
    public static class Request{
        private Long pid;
        private Long fid;
        private int count;
    }

    public Feed Fed(Parent parent, Food food, int count){
        Feed feed = new Feed();
        feed.setFood(food);
        feed.setParent(parent);
        feed.setFedTime(LocalDateTime.now());
        food = feed.getFood();
        food.fedStock(count);
        return feed;
    }
}
