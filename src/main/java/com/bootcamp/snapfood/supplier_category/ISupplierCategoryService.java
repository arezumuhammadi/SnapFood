package com.bootcamp.snapfood.supplier_category;


import java.util.List;

public interface ISupplierCategoryService {

    SupplierCategory save(SupplierCategory category);

    SupplierCategory update(SupplierCategory category);

    void delete(long id);

    List<SupplierCategory> findAll();

}
