package com.bootcamp.snapfood.config.supplier;

import java.util.List;

public interface ISupplierService {
    Supplier save(Supplier supplier);

    Supplier update(Supplier supplier);

    void delete(long id);

    List<Supplier> findAll();

    List<Supplier> findAllBySupplierCategory(Long supplierCategoryId);
}
