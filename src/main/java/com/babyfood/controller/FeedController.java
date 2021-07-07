package com.babyfood.controller;

import com.babyfood.domain.Feed;
import com.babyfood.domain.Food;
import com.babyfood.domain.Parent;
import com.babyfood.domain.QFeed;
import com.babyfood.repo.FeedRepo;
import com.babyfood.repo.FeedRepoQdsl;
import com.babyfood.service.FeedService;
import com.babyfood.service.FoodService;
import com.babyfood.service.ParentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FeedController  {
    @Autowired
    FeedService feedService;
    @Autowired
    ParentService parentService;
    @Autowired
    FoodService foodService;

    @Autowired
    FeedRepoQdsl feedRepoQdsl;


    @GetMapping("/api/fedList")
    public List<Feed.Response> feedList(){
            List<Feed.Response> result = feedService.feedList();
            return result;
    }

    @GetMapping("/api/fedList2")
    public List<Feed.Response> feedList2(){
        List<Feed.Response> result = feedService.feedList2();
        return result;
    }

    @PostMapping("/api/fed")
    public String fed(@RequestBody Feed.Request feedReq){
        Parent parent = parentService.getOne(feedReq.getPid());
        Food food = foodService.getOne(feedReq.getFid());
        int count = feedReq.getCount();
        return feedService.fed(parent, food, count);
    }

    @GetMapping("/api/qdsl")
    public List<Feed.Response> test(Feed feed){

        return feedRepoQdsl.findAll().stream().map(m -> new Feed.Response(m)).collect(Collectors.toList());
    }

}
