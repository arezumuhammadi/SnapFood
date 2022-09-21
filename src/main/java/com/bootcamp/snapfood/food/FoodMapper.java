package com.bootcamp.snapfood.food;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    Food toFood(FoodDTO foodDTO);
    FoodDTO toFoodDTO(Food food);
    List<FoodDTO> toFoodDTOs(List<Food> foods);
}
