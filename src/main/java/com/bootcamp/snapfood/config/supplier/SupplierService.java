package com.bootcamp.snapfood.config.supplier;

import com.bootcamp.snapfood.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierService implements ISupplierService{


    private final SupplierRepository supplierRepository;

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        Supplier savedBefore = getById(supplier.getId());
        savedBefore.setTitle(supplier.getTitle());
        savedBefore.setImage(supplier.getImage());
        return supplierRepository.save(savedBefore);
    }

    private Supplier getById(Long id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isEmpty()) throw new NotFoundException("Supplier NotFound");
        return optionalSupplier.get();
    }

    @Override
    public void delete(long id) {
        Supplier supplier = getById(id);
        supplierRepository.delete(supplier);
    }

    @Override
    public List<Supplier> findAll() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    @Override
    public List<Supplier> findAllBySupplierCategory(Long supplierCategoryId) {
        return supplierRepository.findAllByCategory_Id(supplierCategoryId);
    }
}
