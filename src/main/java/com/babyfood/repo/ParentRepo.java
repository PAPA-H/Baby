package com.babyfood.repo;

import com.babyfood.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepo extends JpaRepository<Parent, Long> {
}
