package com.bootcamp.snapfood.category;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {

    Category save(Category category);
    Category update(Category category);
    void delete(Long id);
    Category getById(Long id);
    Page<Category> paging(Integer page, Integer size);

}
