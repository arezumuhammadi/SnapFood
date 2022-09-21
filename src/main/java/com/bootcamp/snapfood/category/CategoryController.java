package com.bootcamp.snapfood.category;

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
@RequestMapping(value = "/category/")
@AllArgsConstructor
public class CategoryController {

    private ICategoryService categoryService;
    private final CategoryMapper categoryMapper;



    @PostMapping("/v1")
    public ResponseEntity<?> save(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategory(categoryDTO);
        categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<?> update(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategory(categoryDTO);
        categoryService.update(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        CategoryDTO categoryDTO = categoryMapper.toCategoryDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }



    private ResponseEntity<PagingData<CategoryDTO>> getPagingDataResponseEntity(@PathVariable Integer page, Page<Category> categoryPage) {
        int totalPage = categoryPage.getTotalPages();
        List<Category> data = categoryPage.getContent();
        List<CategoryDTO> categoryDTOS = categoryMapper.toCategoryDTOList(data);
        PagingData<CategoryDTO> pagingData = new PagingData<>(totalPage, page, categoryDTOS);
        return ResponseEntity.ok(pagingData);
    }



}
