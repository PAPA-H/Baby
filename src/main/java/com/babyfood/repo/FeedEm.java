package com.babyfood.repo;

import com.babyfood.domain.Feed;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FeedEm {
    @PersistenceContext
    EntityManager em;

    public List<Feed> findAllWithFood(){
        return em.createQuery(
                "select distinct f from Feed f" +
                        " join fetch f.food fo" +
                        " join fetch f.parent p", Feed.class
        ).getResultList();
    }


}
