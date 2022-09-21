package com.bootcamp.snapfood.address;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address/")
@AllArgsConstructor
public class AddressController {
    private IAddressService addressService;
    private final AddressMapper addressMapper;




    @PostMapping
    private ResponseEntity<Void> save(@RequestBody AddressDTO addressDTO) {
        val address = addressMapper.toAddress(addressDTO);
        addressService.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping
    private ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO) {
        val address = addressMapper.toAddress(addressDTO);
        return ResponseEntity.ok(addressMapper.toAddressDto(addressService.update(address)));
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("{id}")
    private ResponseEntity<AddressDTO> findById(@PathVariable Long id) {
        val address = addressService.findById(id);
        return ResponseEntity.ok(addressMapper.toAddressDto(address));
    }


    @GetMapping
    private ResponseEntity<List<AddressDTO>> findAll() {
        return ResponseEntity.ok(addressMapper.toAddressDTOs(addressService.findAll()));
    }



}
