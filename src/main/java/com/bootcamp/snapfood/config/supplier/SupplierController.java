package com.bootcamp.snapfood.config.supplier;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier/")
@AllArgsConstructor
public class SupplierController {

    private ISupplierService supplierService;
    private final SupplierMapper supplierMapper;


    @PostMapping
    public ResponseEntity<Void> saveSupplier(@RequestBody SupplierDTO dto) {
        Supplier supplier = supplierMapper.toSupplier(dto);
        supplierService.save(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<SupplierDTO> updateSupplier(@RequestBody SupplierDTO dto) {
        Supplier supplier = supplierMapper.toSupplier(dto);
        SupplierDTO supplierDTO = supplierMapper.toSupplierDTO(supplierService.update(supplier));
        return ResponseEntity.ok(supplierDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SupplierDTO> deleteSupplier(@PathVariable Long id) {
        supplierService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getSupplier() {
        List<SupplierDTO> supplierDTOS = supplierMapper.toSupplierDTOs(supplierService.findAll());

        return ResponseEntity.ok(supplierDTOS);
    }

    @GetMapping("/SupplierCategory/{id}")
    public ResponseEntity<List<SupplierDTO>> getSupplierByCategoryId(@PathVariable Long id) {
        List<SupplierDTO> supplierDTOS = supplierMapper.toSupplierDTOs(supplierService.findAllBySupplierCategory(id));

        return ResponseEntity.ok(supplierDTOS);
    }

}
