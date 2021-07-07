package com.babyfood.repo;

import com.babyfood.domain.Feed;
import com.babyfood.domain.QFood;
import com.babyfood.domain.QParent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.babyfood.domain.QFeed.*;

@Repository
public class FeedRepoQdsl extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;
    public FeedRepoQdsl(JPAQueryFactory queryFactory){
        super(Feed.class);
        this.queryFactory = queryFactory;
    }

    public List<Feed> findAll(){
        return queryFactory.selectFrom(feed)
                .innerJoin(feed.food, QFood.food)
                .innerJoin(feed.parent, QParent.parent)
                .fetchJoin()
                .distinct()
                .fetch();
    }




}

