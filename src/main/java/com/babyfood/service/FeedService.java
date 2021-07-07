package com.babyfood.service;

import com.babyfood.domain.Feed;
import com.babyfood.domain.Food;
import com.babyfood.domain.Parent;
import com.babyfood.repo.FeedEm;
import com.babyfood.repo.FeedRepo;
import com.babyfood.repo.FoodRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedService {
    @Autowired
    FeedRepo feedRepo;
    @Autowired
    FeedEm feedEm;


    @Transactional
    public String fed(Parent parent, Food food, int count){
        Feed feed = new Feed();
        feed = feed.Fed(parent, food, count);
        feedRepo.save(feed);
        return "Fed Success";
    }

    public List<Feed.Response> feedList(){
        List<Feed> feed = feedRepo.findAll();
//        ModelMapper mp = new ModelMapper();
//        List<Feed.Response> result = feed.stream().map(m -> mp.map(m, Feed.Response.class)).collect(Collectors.toList());
        List<Feed.Response> result = feed.stream().map(f -> new Feed.Response(f)).collect(Collectors.toList());
        return result;
    }

    public List<Feed.Response> feedList2(){
        List<Feed> feed = feedEm.findAllWithFood();
//        ModelMapper mp = new ModelMapper();
//        List<Feed.Response> result = feed.stream().map(m -> mp.map(m, Feed.Response.class)).collect(Collectors.toList());
        List<Feed.Response> result = feed.stream().map(f -> new Feed.Response(f)).collect(Collectors.toList());
        return result;
    }

}
