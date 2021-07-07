package com.babyfood.repo;

import com.babyfood.domain.Feed;
import com.babyfood.domain.QFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.jar.Attributes;

public interface FeedRepo extends JpaRepository<Feed, Long>, QuerydslPredicateExecutor<Feed> {

    @Query("SELECT distinct f FROM Feed f join fetch f.food fo join fetch f.parent p")
    List<Feed> findAll();
//    @EntityGraph(attributePaths = {"parent","food"})
//    List<Feed> findAll();



}