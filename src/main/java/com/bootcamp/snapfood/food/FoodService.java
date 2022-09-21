package com.bootcamp.snapfood.food;

import com.bootcamp.snapfood.common.exception.NotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodService implements IFoodService{

    private  FoodRepository foodRepository;

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food update(Food food) {
        Food savedBefore = getById(food.getId());
        savedBefore.setImage(food.getImage());
        return foodRepository.save(savedBefore);
    }

    @Override
    public void delete(Long id) {

    }

    public Food getById(Long id) {
        Optional<Food> optionalSupplier = foodRepository.findById(id);
        if (optionalSupplier.isEmpty()) throw new NotFoundException("FOOD NotFound");
        return optionalSupplier.get();
    }

    public FoodService() {
        super();
    }

    public void delete(long id) {
        Food food = getById(id);
        foodRepository.delete(food);
    }


    @Override
    public List<Food> findAll() {
        return (List<Food>) foodRepository.findAll();
    }


    @Override
    public List<Food> findAllByFoodCategory(Long foodCategoryId) {
        return foodRepository.findAllByCategory_Id(foodCategoryId);
    }


}
