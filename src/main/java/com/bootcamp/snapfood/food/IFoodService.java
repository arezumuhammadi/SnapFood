package com.bootcamp.snapfood.food;

import java.util.List;

public interface IFoodService {
    Food save(Food food);
    Food update(Food food);
    void delete(Long id);
    Food getById(Long id);
    List<Food> findAll();

    List<Food> findAllByFoodCategory(Long foodCategoryId);
}
