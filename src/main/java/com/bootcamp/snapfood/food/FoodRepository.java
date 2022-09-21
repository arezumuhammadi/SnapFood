package com.bootcamp.snapfood.food;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends PagingAndSortingRepository<Food, Long> {


   Food findByName(String name);


    Page<Food> findAll(Pageable pageable);


    List<Food> findAll(Specification<Food> specification);

    List<Food> findAllByCategory_Id(Long foodCategoryId);
}
