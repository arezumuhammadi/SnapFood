package com.bootcamp.snapfood.category;

import com.bootcamp.snapfood.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "categoryCache", allEntries = true),
    })
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "categoryCache", allEntries = true),
    })
    public Category update(Category category) {
        Category lastSavedCategory = getById(category.getId());
        lastSavedCategory.setTitle(category.getTitle());
        lastSavedCategory.setImage(category.getImage());
        return categoryRepository.save(lastSavedCategory);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "categoryCache", allEntries = true),
    })
    public void delete(Long id) {
        getById(id);
        categoryRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "categoryCache", key = "#id")
    public Category getById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new NotFoundException("Category Not Found!");
        }
        return optionalCategory.get();
    }

    @Override
    public Page<Category> paging(Integer page, Integer size) {
        return categoryRepository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    }



}
