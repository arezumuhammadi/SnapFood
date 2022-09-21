package com.bootcamp.snapfood.food;

import com.bootcamp.snapfood.common.PagingData;
import com.bootcamp.snapfood.common.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/food/")
@AllArgsConstructor
public class FoodController {

    private IFoodService foodService;

    private FoodMapper foodMapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody FoodDTO dto) {
        Food food = foodMapper.toFood(dto);
        foodService.save(food);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<FoodDTO> update(@RequestBody FoodDTO dto) {
        Food food = foodMapper.toFood(dto);
        FoodDTO foodDTO = foodMapper.toFoodDTO(foodService.update(food));
        return ResponseEntity.ok(foodDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<FoodDTO> delete(@PathVariable Long id) {
        foodService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<FoodDTO>> get() {
        List<FoodDTO> foodDTOS = foodMapper.toFoodDTOs(foodService.findAll());

        return ResponseEntity.ok(foodDTOS);
    }



}
