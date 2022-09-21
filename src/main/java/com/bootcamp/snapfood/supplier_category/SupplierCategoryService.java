package com.bootcamp.snapfood.supplier_category;

import com.bootcamp.snapfood.category.ICategoryService;
import com.bootcamp.snapfood.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupplierCategoryService implements ISupplierCategoryService {

    private SupplierCategoryRepository supplierCategoryRepository;


    @Override
    public SupplierCategory save(SupplierCategory category) {
        return supplierCategoryRepository.save(category);
    }

    @Override
    public SupplierCategory update(SupplierCategory category) {

        return null;
    }

    private SupplierCategory getById(Long id) {
        Optional<SupplierCategory> optionalSupplierCategory = supplierCategoryRepository.findById(id);

        if (optionalSupplierCategory.isEmpty()){
            throw new NotFoundException("Not Found Supplier Category");
        }

        return optionalSupplierCategory.get();
    }

    @Override
    public void delete(long id) {
        val category = getById(id);
        supplierCategoryRepository.delete(category);
    }

    @Override
    public List<SupplierCategory> findAll() {
        return (List<SupplierCategory>) supplierCategoryRepository.findAll();
    }
}
